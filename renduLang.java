// renduLang.java

abstract class LangTest {

    abstract void affiche ();

}//LangTest

// *****

// TYPES 

abstract class Types extends LangTest {

    abstract void affiche ();

}//Types

class Integer extends Types {

    int e;
	
	Integer(int e){
		this.e=e;
	}

    void affiche () {
        system.out.println(e);
    }//affichage

}//Int

class Boolean extends Types {

    boolean e;

	Boolean(boolean e){
		this.e=e;
	}
	
    void affiche () {
        system.out.println(e);
    }//affichage

}//Bool

class Array extends Types {

    ArrayList<Type> e;

	Array(ArrayList<Type> e){
		this.e=e;
	}
	
    void affiche () {
        system.out.println(e);
    }//affichage

}//Array

// ****

// CONSTANTES 

abstract class Constantes extends LangTest {

    abstract void affiche ();

}//Cstes

class Number extends Constantes {

    int e;

	Number(int e){
		this.e=e;
	}
	
    void affiche () {
        system.out.println(e);
    }//affichage

}//Number

class True extends Constantes {

    boolean e=True;   // Comment on gère les valeurs par défautl ?

	True(boolean e){
		this.e=e;
	}
	
    void affiche () {
        system.out.println(e);
    }//affichage

}//True

class False extends Constantes {

    boolean e=False;

	False(boolean e){
		thie.e=e;
	}
	
    void affiche () {
        system.out.println(e);
    }//affichage

}//False

// ****

// UNAIRE

class Inv extends LangTest {

    void affiche () {
        system.out.println("-");
    }//affichage

}//Inv

class notInv extends LangTest;//notInv

// ****

// BINAIRE

abstract class Binaire extends LangTest{

    abstract void affiche();

}//Binaire

class Add extends Binaire {

    void affiche () {
        system.out.println(" + ";
    }//eval

}//Add

class Minus extends Binaire {

    void affiche () {
        system.out.println(" - ");
    }//affichage

}//Minus

class Mul extends Binaire {

    void affiche () {
        system.out.println(" x ");
    }//affichage

}//Mul

class Div extends Binaire {

    void affiche () {
        system.out.println(" / ");
    }//affichage

}//Div

class And extends Binaire {

    void affiche () {
        system.out.println(" and ");
    }//affichage

}//And

class Or extends Binaire {

    void affiche () {
        system.out.println(" or ");
    }//affichage

}//Or

class Inf extends Binaire {

    void affiche () {
        system.out.println(" < ");
    }//affichage

}//Inf

class InfEg extends Binaire {

    void affiche () {
        system.out.println(" <= ");
    }//affichage

}//InfEg

class Sup extends Binaire {

    void affiche () {
        system.out.println(" > ");
    }//affichage

}//Sup

class SupEg extends Binaire {

    void affiche () {
        system.out.println(" >= ");
    }//affichage

}//SupEg

class Eg extends Binaire {

    void affiche () {
        system.out.println(" = ");
    }//affichage

}//Eg

class NotEg extends Binaire {

    void affiche () {
        system.out.println(" != ");
    }//affichage

}//NotEg

// ****

// CIBLES

abstract class Cibles extends LangTest {

    abstract void affiche();

}//Cibles

class Read extends Cibles{

    LangTest e;

    Read(LangTest e){
        this.e = e;
    }

    void affiche () {
        system.out.println("read "+e.affiche());
    }//affichage

}//Read

class Write extends Cibles{

    LangTest e;

    Write(LangTest e){
        this.e = e;
    }

    void affiche () {
        system.out.println("write "+ e.affiche());
    }//affichage

}//Write

class Func extends Cibles{

    LangTest e;

    Func(LangTest e){
        this.e = e;
    }

    void affiche () {
        system.out.println("f ="+ e.affiche());
    }//affichage

}//Func

//****

//EXPRESSION

abstract class Exp extends LangTest{
    abstract void affiche();
}//Exp

class CsteExp extends Exp {

    Constantes e;

    CsteExp (Constantes e) {
        this.e = e;
    }//CsteExp

    void affiche () {
        system.out.println(e);
    }//affichage

}//Cste Exp

class VarExp extends Exp{

    String x;

    VarExp(String x){
        this.x=x;
    }

    void affiche(){
        system.out.println(x);
    }

}//VarExp

class UopExp extends Exp{

    Unaire u;
    Exp e;

    UopExp (Unaire u, Exp e){
        this.u = u;
        this.e = e;
    }

    void affiche () {
        system.out.println(u + e);
    }//affichage

}//UopExp

class BopExp extends Exp{

    Binaire u;
    Exp e1;
    Exp e2;

    BopExp (Binaire u, Exp e1, Exp e2){
        this.u = u;
        this.e1 = e1;
        this.e2=e2;
    }

    void affiche () {
        system.out.println(e1 + u + e2);
    }//affichage

}//BopExp

class FuncExp extends Exp{

    Exp[] e;
    Cibles c;

    FuncExp (Exp[] e, Cibles c){
        this.e =e;
        this.c =c;
    }

    void affiche () {
        system.out.println(c +"(" + e +")");
    }//affichage

}//FuncExp

class TabExp extends Exp{

    ArrayList<Exp> e;
    Exp i;

    tabExp (ArrayList<Exp> e, Exp i){
        this.e =e;
        this.i =i;
    }

    void affiche () {
        system.out.println(e+"["+i+"]");
    }//affichage

}//TabExp

class newArrayExp extends Exp{

    Types t;
    Exp e;

    newArrayExp(Types t, Exp e){
        this.e=e;
        this.t=t;
    }

    void affiche(){
        system.out.println("new array of "+t+"["+e+"]");
    }
}//newArrayExp

// ****

//INSTRUCTIONS

abstract class Instr extends LangTest{

    abstract void affiche();

}//Instr

class Affect extends Instr{

    VarExp x;
    Exp e;

    Affect (VarExp x, Exp e){
        this.x=x;
        this.e=e;
    }

    void affiche(){
        system.out.println(x+":="+e);
    }

}//Affect

class AffectTab extends Instr{

    ArrayList<Exp> x;
    Exp e1;
    Exp e2;

    AffectTab (ArrayList<Exp> x, Exp e1, Exp e2){
        this.x=x;
        this.e1=e1;
        this.e2=e2;
    }

    void affiche(){
        system.out.println(x+"["+e1+"]:="+e2);
    }
    
}//AffectTab

class If extends Instr{

    Exp e3;
    Exp e1;
    Exp e2;

    AffectTab (Exp e1, Exp e2, Exp e3){
        this.e3=e3;
        this.e1=e1;
        this.e2=e2;
    }

    void affiche(){
        system.out.println("If "+e1+" then "+e2+" else "+e3);
    }
    
}//If

class While extends Instr{

    Exp e;
    Inst i;

    While (Exp e, Instr i){
        this.e=e;
        this.i=i;
    }

    void affiche(){
        system.out.println("While "+e+" do "+i);
    }

}//While

class FuncInstr extends Instr{

    ArrayList<Exp> e;
    Cibles c;

    FuncInst (ArrayList<Exp> e, Cibles c){
        this.e =e;
        this.c =c;
    }

    void affiche () {
        system.out.println(c +"(" + e +")");
    }//affichage

}//FuncInstr

class Skip extends Instr{

    void affiche () {
        system.out.println("skip");
    }//affichage

}//Skip

class DoubleInstr extends Instr{

    Instr i1;
    Instr i2;

    DoubleInstr(Instr i1, Instr i2){
        this.i1=i1;
        this.i2=i2;
    }

    void affiche(){
        system.out.println(i1+";"+i2);
    }
	
}//DoubleInstr

// ****

//DEFINITIONS

abstract class Def extends LangTest{
    
	abstract void affiche();

}

abstract class VarTyp extends LangTest{

    VarExp x;
    Types t;

    VarTyp(VarExp x, Types t){
        this.x=x;
        this.t=t;
    }

    void affiche(){
        system.out.println(x+":"+t);
    }

}//VarTyp Variable tipée

class DeclFunc extends Def{

    String f;
    ArrayList <VarTyp> a;
    Types t;

    DeclFunc (String f,ArrayList<VarTyp> a,Types t){
        this.f=f;
        this.a=a;
        this.t=t;
    }

    void affiche(){
        system.out.println(f+"((");
		system.out.println(a[i]);
		system.out.println(")[:"+t+"]");
        // Mettre un while pour afficher tout le tableau ?
    }

}//DeclFunc

class DeclVar extends Def{
	
	//var
	ArrayList <VarTyp> a;
	
	DeclVar(ArrayList <VarTyp> a){
		this.a=a;
	}
	
	void affiche(){
		system.out.println("[var ("+a+")]");
	}
	
}//DeclVar

class DefInstr extends Def{

	Instr i;
	
	DefInstr(Instr i){
		this.i=i;
	}
	
	void affiche(){
		system.out.println(i);
	}

}//DefInstr

//****

//PROGRAMMES

abstract class Prog extends LangTest{

	abstract void affiche();

}//Prog

class ProgVar extends Prog{
	
	//var
	ArrayList <VarTyp> a;
	
	ProgVar(ArrayList <VarTyp> a){
		this.a=a;
	}
	
	void affiche(){
		system.out.println("[var ("+a+")]");
	}
	
}//ProgVar

class ProgDef extends Prog{

	ArrayList <Def> = a;

	ProgDef(ArrayList<Def> a){
		this.a=a;
	}

	void affiche(){
		system.out.println(a);
	}

}//ProgDef

class ProgInstr extends Prog{

	Instr i;

	ProgInstr(Instr i){
		this.i=i;
	}

	void affiche(){
		system.out.println(i);
	}

}//ProgInstr