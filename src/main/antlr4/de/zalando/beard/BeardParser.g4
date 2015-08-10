parser grammar BeardParser;

options {
  tokenVocab=BeardLexer;
}

@parser::header{
import de.zalando.beard.ast.*;
}

beard
locals [scala.collection.immutable.List<Statement> result]
      : statement*
      ;

statement
locals [Statement result]
         : structuredStatement
         | interpolation
         | text
         ;

structuredStatement
    : ifStatement
    ;


ifStatement
locals [IfStatement result]
    : ifInterpolation statement+ endifInterpolation # IfOnlyStatement
    | ifInterpolation ifStatements+=statement+ elseInterpolation elseStatements+=statement+ endifInterpolation # IfElseStatement
    ;

ifInterpolation
    : LL IF RR
    ;

elseInterpolation
    : LL ELSE RR
    ;

endifInterpolation
    : LL SLASH IF RR
    ;


interpolation
locals [Interpolation result]
    : idInterpolation
    | attrInterpolation
    ;

// {{address.street.number}}
idInterpolation
locals [IdInterpolation result]
    : LL identifier (DOT identifier)* RR
    ;

// {{address street="Ferdinand" number="1"}}
attrInterpolation
locals [AttrInterpolation result]
    : LL identifier attribute* RR
    ;

attribute
locals [scala.Tuple2<String, String> result]
    : identifier START_ATTR attrValue
    ;

attrValue
locals [String result]
    : START_ATTR_VALUE ATTR_TEXT END_ATTR_VALUE
    ;

identifier
locals [Identifier result]
    : IDENTIFIER
    ;

text
locals [Text result]
    : TEXT
    ;