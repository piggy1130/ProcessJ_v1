/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syntax;

import ast.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ben
 */
public class ParseVirtualStack {
    
    // TODO: write a simple predicate function to check for expressions
    // and statements -- the 'oracle' should be executed between the
    // scanner and the parser and should use the predicate function to
    // answer the following question: ``if the scanner returned token A,
    // and the CUP parser produces symbol B in the current state, should
    // we push a stack in order to define a sublexical mode to creates
    // `rules' that only apply to the current context being parsed or not
    // If the answer is `yes', then create a sublexical mode by pushing a
    // stack of symbols on to the stack. Do nothing otherwise.''
    
    // Tell the binding oracle what kind of binding we are lookinf for
    public static enum OracleRequest {
        ORACLE_EXPRESSION,
        ORACLE_STATEMENT,
        ORACE_SYMBOL;
    }
    
    /** The lookahead symbol -- when parsing fails, pop the top element
     * (or newest element) off the stack to find the syntax error */
    public Object currSymbol;
    
    /** A stack of non-terminal and terminal symbols generated by cup */
    public Stack<NodeCtx> stack = new Stack<>();
    
    /** Direct reference to a source file */
    public TreeCtx tree;
    
    /** Direct reference to a node context of a tree context */
    public NodeCtx node = null;
    
    /** The source program currently being parsed */
    public String filename;
    
    /** Line number in the source program  */
    public int next = -1;
    
    public boolean hasParens = false;
    
    public ParseVirtualStack(String filename) {
        this.filename = filename;
        this.tree = new TreeCtx();
    }
    
    public void scan(ast.Token token) {
        if (next != token.getStartLine()) {
            next = token.getStartLine();
            node = token.asRuleContext();
            tree.addRuleNode(token);
        } else
            node.add(token);
    }
    
    public void parse(Object symbol, OracleRequest request) {
        Expression e = null;
        switch (request) {
            case ORACE_SYMBOL:
                if (hasParens) {
                    NodeCtx token = node.getLeaf();
                    hasParens = false;
                    node = stack.pop();
                    node.add(token);
                } else
                    node = stack.pop();
                break;
            case ORACLE_EXPRESSION:
                e = (Expression) symbol;
                hasParens = e.hasParens;
                stack.push(node);
                node = new RuleCtx(new Token("*"));
                break;
            case ORACLE_STATEMENT:
                Statement st = (Statement) symbol;
                if (st instanceof ExprStat) {
                    e = ((ExprStat) st).expr();
                    hasParens = e.hasParens;
                    stack.push(node);
                    node = new RuleCtx(new Token("*"));
                } else
                    ; // check for missing semicolon or curly brackets??
                break;
            default:
                break;
        }
    }
}
