//GrammarBNF.g4

grammar PP;

//Expressions: (UOP & BOP)
exp returns [PPExpr value]:
v = Var {$value=new PPVar($v.text);} 
| n=Number {$value=new PPCte($n.value);} 
| '-' e=exp {$value = new PPInv($e.value);}
| 'not' e=exp {$value = new PPNot($e.value);}
| e1=exp '+' e2=exp {$value = new PPAdd($e1.value, $e2.value);}
| e1=exp '-' e2=exp {$value = new PPSub($e1.value, $e2.value);}
| e1=exp 'x' e2=exp {$value = new PPMul($e1.value, $e2.value);}
| e1=exp '/' e2=exp {$value = new PPDiv($e1.value, $e2.value);}
| e1=exp 'and' e2=exp {$value = new PPAnd($e1.value, $e2.value);}
| e1=exp 'or' e2=exp {$value = new PPOr($e1.value, $e2.value);}
| e1=exp '<' e2=exp {$value = new PPLt($e1.value, $e2.value);}
| e1=exp '<=' e2=exp {$value = new PPLe($e1.value, $e2.value);}
| e1=exp '=' e2=exp {$value = new PPEq($e1.value, $e2.value);}
| e1=exp '!=' e2=exp {$value = new PPNe($e1.value, $e2.value);}
| e1=exp '>=' e2=exp {$value = new PPGe($e1.value, $e2.value);}
| e1=exp '>' e2=exp {$value = new PPGt($e1.value, $e2.value);}
| v=callee '('l=listExpr')' {$value = new PPFunCall($v.value, $l.value);} 
| e1=exp'['e2=exp']' {$value = new PPArrayGet($e1.value, $e2.value);}
| 'new array of' t=type'['e=exp']' {$value =new PPArrayAlloc($t.value,$e.value);} ;

Number : ('0'..'9')+;

//String
Var : ('a'..'z'|'A'..'Z')+;

//Instructions
inst returns [PPInst value]:
v = Var ':=' e=exp {$value = new PPAssign($v.value,$e.value);}
| e1=exp'['e2=exp']' {$value = new PPArraySet($e1.value, $e2.value);}
| 'if' e1=exp 'then' e2=exp 'else' e3=exp {$value = new PPCond($e1.value,$e2.value,$e3.value);}
| 'while' e=exp 'do' i=inst {$value = new PPWhile($e.value,$i.value);}
| v=callee '('l=listExpr')' {$value = new PPProcCall($v.value, $l.value);}
| 'skip' {$value = new PPSkip();}
| i1=inst ';' i2=inst {$value = new PPSeq($i1.value,$i2.value);} ;

//Callee = cibles d'appels
callee returns [Callee value]:
'Read' {$value = new Read();}
| 'Write' {$value = new Write();}
| 'User' {$value = new User();};

listExpr 
@init {$value = new ArrayList<PPExpr>();}
returns [ArrayList<PPExp> value]:
(e=expr{$value.add($e.value);})+;

//Type
type returns [Type value]: 
'int' {$value = new Int();}
|'bool' {$value = new Bool();}
|'array' {$value = new Array();} ;


//Programme
prog returns [PPProg value]: 
'['p=listPair']' d=listDef i=inst {$value=new PPProg($p.value,$d.value,$i.value);}; 

//Pair
pair returns [Pair<String,Type> value]:
L=var ':' R=type {$value = new Pair<String,Type>($L.value,$R.value);};

listPair
@init {$value = new ArrayList<Pair<String,Type>>();}
returns [ArrayList<Pair<String,Type>> value]:
(p=pair{$value.add($p.value);})+;

//Definitions procédures et fonctions
def returns [PPDef value]:
v=var '(' globals=listPair ')' ':' t=type locals=listPair i=inst {$value = new PPFun($v.value,$globals.value,$locals.value,$i.value,$t.value);}
| v=var '(' globals=listPair ')'  locals=listPair i=inst {$value = new PPProc($v.value,$globals.value,$locals.value,$i.value);};

listDef
@init {$value = new ArrayList<PPDef>();}
returns [ArrayList<PPDef> value]:
(d=def{$value.add($p.value);});

WS : [ \t\r\n]+ -> skip ;