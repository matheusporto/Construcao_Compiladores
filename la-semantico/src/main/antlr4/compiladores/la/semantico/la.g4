// T1 - Analisador Léxico

grammar la;

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
SIMBOLO_NAO_IDENTIFICADO: '!' | ';' | '@' | '$' | '¨' | '}' |'~' |  '%' | '?' | '|';



// T2 - Analisador Sintático



programa: declaracoes 'algoritmo' corpo 'fim_algoritmo';

declaracoes: (decl_local_global)*;

decl_local_global: declaracao_local | declaracao_global;

declaracao_local:  'declare' variavel 
                  | 'constante' IDENT ':' tipo_basico '=' valor_constante
                  | 'tipo' IDENT ':' tipo;

variavel: identificador (',' identificador)* ':' tipo;

identificador: IDENT ('.' IDENT)* dimensao;

dimensao: ('[' exp_aritmetica ']')*;

tipo: registro | tipo_estendido;

tipo_basico: 'literal' | 'inteiro' | 'real' | 'logico';

tipo_basico_ident: tipo_basico | IDENT;

tipo_estendido: ('^')? tipo_basico_ident;   

valor_constante: CADEIA | NUM_INT | NUM_REAL | 'verdadeiro' | 'falso';

registro: 'registro' (variavel)* 'fim_registro';

declaracao_global: 'procedimento' IDENT '(' (parametros)? ')' (declaracao_local)* (cmd)* 'fim_procedimento'
                    | 'funcao' IDENT '(' (parametros)? ')' ':' tipo_estendido (declaracao_local)* (cmd)* 'fim_funcao';

parametro: ('var')? identificador (',' identificador)* ':' tipo_estendido;

parametros: parametro (',' parametro)*;

corpo: (declaracao_local)* (cmd)*;

cmd: cmdleia | cmdescreva | cmdse | cmdcaso | cmdpara | cmdenquanto
     | cmdfaca | cmdatribuicao | cmdchamada | cmdretorne;

cmdleia: 'leia' '(' ('^')? identificador (',' ('^')? identificador)* ')';
cmdescreva: 'escreva' '(' expressao (',' expressao)* ')';
cmdse: 'se' expressao 'entao' (cmd)* ('senao' (cmd)*)? 'fim_se';
cmdcaso: 'caso' exp_aritmetica 'seja' selecao ('senao' (cmd)*)? 'fim_caso';
cmdpara: 'para' IDENT '<-' exp_aritmetica 'ate' exp_aritmetica 'faca' (cmd)* 'fim_para';
cmdenquanto: 'enquanto' expressao 'faca' (cmd)* 'fim_enquanto';
cmdfaca: 'faca' (cmd)* 'ate' expressao;
cmdatribuicao: ('^')? identificador '<-' expressao;
cmdchamada: IDENT '(' expressao (',' expressao)* ')';
cmdretorne: 'retorne' expressao;

selecao: (item_selecao)*;
item_selecao: constantes ':' (cmd)*;

constantes: numero_intervalo (',' numero_intervalo)*;

numero_intervalo: (op_unario)? NUM_INT ('..' (op_unario)? NUM_INT)?;

op_unario: '-';

exp_aritmetica: termo (op1 termo)*;
termo: fator (op2 fator)*;
fator: parcela (op3 parcela)*;

op1: '+' | '-';
op2: '*' | '/';
op3: '%';

parcela: (op_unario)? parcela_unario | parcela_nao_unario;
parcela_unario: ('^')? identificador
                | IDENT '(' expressao (',' expressao)* ')'
                | NUM_INT
                | NUM_REAL
                | '(' expressao ')';
parcela_nao_unario: '&' identificador | CADEIA;

exp_relacional: exp_aritmetica (op_relacional exp_aritmetica)*;

op_relacional: '=' | '<>' | '>=' | '<=' | '>' | '<';

expressao: termo_logico (op_logico_1 termo_logico)*;
termo_logico: fator_logico (op_logico_2 fator_logico)*;
fator_logico: ('nao')? parcela_logica;
parcela_logica: ('verdadeiro' | 'falso') | exp_relacional;

op_logico_1: 'ou';
op_logico_2: 'e';
