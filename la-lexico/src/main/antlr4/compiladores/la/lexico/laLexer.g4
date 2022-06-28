lexer grammar laLexer;

// comentario - qualquer coisa entre chaves (na mesma linha)  
COMENTARIO: '{' ~('\n'|'\r'|'}')* '}'-> skip;

// comentario errado - não ocorre o fechamento do comentario 
COMENTARIO_ERRADO: '{' ~('\n'|'\r'|'}')* '\n';

// ignorar \r\t\n 
TABULACAO : ( ' '| '\t'| '\r'| '\n') -> skip;
 
// palavras chave
PALAVRAS_CHAVE: 'algoritmo' | 'fim_algoritmo'
		| 'declare' | 'constante' | 'tipo' 
		| 'literal' | 'inteiro' | 'real' | 'logico'
		| 'verdadeiro' | 'falso'
		| 'registro' | 'fim_registro' 
                | 'procedimento' | 'fim_procedimento'
                | 'funcao' | 'fim_funcao'
                | 'var' | 'leia' | 'escreva'
                | 'se' | 'entao' | 'senao' | 'fim_se'
                | 'caso' | 'seja' | 'fim_caso' 
                | 'para' | 'ate' | 'faca' | 'fim_para'
                | 'enquanto' | 'fim_enquanto' 
                | 'retorne' | 'nao' | '<-' ;

// numero inteiro - sequencia de digitos uma ou mais vezes 
NUM_INT: ('0'..'9')+; 

// numero real - sequencia de digitos uma ou mais vezes com um '.' entre as sequencias 
NUM_REAL: ('0'..'9')+'.'('0'..'9')+;

// simbolos e operadores que pertecem a linguagem 
SIMBOLOS_E_OPERADORES: '+' | '-' | '*' | '/' |'%' | 'e' | 'ou' 
| '<>' | '>=' | '<=' | '>' | '<' | ':' | '=' | ',' | '[' | ']' |
 '^' | '(' | ')' | '&' | '..' | '.';

// identificadores - sequencia de digitos ou sublinha seguidos por numeros ou digitos(nao pode comecar com digito) 
IDENT: ('A'..'Z' | 'a'..'z' | '_')('A'..'Z' | 'a'..'z' | '0'..'9' | '_')*;

// cadeia - qualquer coisa entre aspas 
CADEIA: '"'(~('"'|'\n'))*'"';

// cadeira errada - abre aspas e nao fecha
CADEIA_ERRADA: '"'(~('"'|'\n'))* '\n';

// simbolos nao reconhecidos na linguagem LA 
SIMBOLO_NAO_IDENTIFICADO: '!' | ';' | '@' | '$' | '¨' | '}' |'~' |  '%' | '?' ;


