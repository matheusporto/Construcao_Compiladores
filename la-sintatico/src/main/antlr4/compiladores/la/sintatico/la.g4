// T1 - Analisador Léxico

grammar la;

NUMERO: [0-9]+;
ID: [a-zA-Z]+;
OP: '<-' | '+' | '-' | '*' | '/';
WS: (' ' | '\t' | '\n' | '\r') ->skip;

programa: cmd+ EOF;
cmd: expr | 'read' ID | 'write' expr;
expr: termo (OP termo)*;
termo: NUMERO | ID | '(' expr ')';
