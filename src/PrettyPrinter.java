/**
 * Created by Yafael on 2/27/2017.
 */
public class PrettyPrinter {

    public static void printSpaces(int num){
        int i;
        for(i = 1; i <= num; i++){
            System.out.print("  ");
        }
    }

    public static void print(Prog p){
        System.out.print("program\n  ");

        Decl_Seq decl_seq = p.getDeclSeq();
        printDeclSeq(decl_seq);

        System.out.print("begin\n");

        Stmt_Seq stmt_seq = p.getStmtSeq();
        printStmtSeq(stmt_seq, 2);

        System.out.print("  end\n");
    }

    public static void printDeclSeq(Decl_Seq decl_seq){
        Decl decl = decl_seq.getDecl();
        printDecl(decl);
        System.out.print("\n  ");

        if(decl_seq.getChoice() == 2){
            Decl_Seq declSeq2 = decl_seq.getDecl_seq();
            printDeclSeq(declSeq2);
        }
    }

    public static void printStmtSeq(Stmt_Seq stmt_seq, int space){
        Stmt stmt = stmt_seq.getStmt();
        printStmt(stmt, space);
        System.out.println();

        if(stmt_seq.getChoice() == 2){
            Stmt_Seq stmtSeq2 = stmt_seq.getStmt_seq();
            printStmtSeq(stmtSeq2, space);
        }
    }

    public static void printDecl(Decl decl){
        System.out.print("int ");
        Id_List idList = decl.getId_list();
        printIdList(idList);
        System.out.print(";");
    }

    public static void printIdList(Id_List id_list){
        Id id = id_list.getId();
        printId(id);

        if(id_list.getChoice() == 2){
            Id_List idList2 = id_list.getId_list();
            System.out.print(", ");
            printIdList(idList2);
        }
    }

    public static void printStmt(Stmt stmt, int space){
        int choice = stmt.getChoice();

        if(choice == 1){
            Assign assign = stmt.getAssign();
            printAssign(assign, space);
        }else if(choice == 2){
            If iff = stmt.getIf();
            printIf(iff, space);
        }else if(choice == 3){
            Loop looop = stmt.getLoop();
            printLoop(looop, space);
        }else if(choice == 4){
            In in = stmt.getIn();
            printIn(in, space);
        }else if(choice == 5){
            Out out = stmt.getOut();
            printOut(out, space);
        }
    }

    public static void printAssign(Assign assign, int space){
        printSpaces(space);
        Id id = assign.getId();
        printId(id);
        System.out.print(" = ");
        Exp exp = assign.getExp();
        printExp(exp);
        System.out.print(";");
    }

    public static void printIf(If iff, int space){
        printSpaces(space);
        System.out.print("if ");
        Cond cond = iff.getCond();
        printCond(cond);

        System.out.print(" then\n");

        Stmt_Seq stmtSeq = iff.getStmt_seq1();
        printStmtSeq(stmtSeq, space + 1);

        if(iff.getChoice() == 2){
            printSpaces(space);
            System.out.print("else\n");
            printStmtSeq(iff.getStmt_seq2(), space + 1);
        }
        printSpaces(space);
        System.out.print("end;");
    }

    public static void printLoop(Loop looop, int space){
        printSpaces(space);
        System.out.print("while ");

        Cond cond = looop.getCond();
        printCond(cond);

        System.out.print(" loop\n");

        Stmt_Seq stmtSeq = looop.getStmt_seq();
        printStmtSeq(stmtSeq, space + 1);

        printSpaces(space);
        System.out.print("end;");
    }

    public static void printIn(In in, int space){
        printSpaces(space);
        System.out.print("read ");
        Id_List idList = in.getId_list();
        printIdList(idList);
        System.out.print(";");
    }

    public static void printOut(Out out, int space){
        printSpaces(space);
        System.out.print("write ");
        Id_List idList = out.getId_list();
        printIdList(idList);
        System.out.print(";");
    }

    public static void printCond(Cond cond){
        int choice = cond.getChoice();

        if(choice == 1){
            Comp comp = cond.getComp();
            printComp(comp);
        }else if(choice == 2){
            System.out.print("!");
            Cond cond1 = cond.getCond1();
            printCond(cond1);
        }else if(choice == 3){
            System.out.print("[ ");
            Cond cond1 = cond.getCond1();
            printCond(cond1);

            System.out.print(" and");

            Cond cond2 = cond.getCond2();
            printCond(cond2);

            System.out.print(" ]");
        }else if(choice == 4){
            System.out.print("[ ");

            Cond cond1 = cond.getCond1();
            printCond(cond1);

            System.out.print(" or");

            Cond cond2 = cond.getCond2();
            printCond(cond2);

            System.out.print(" ]");
        }
    }

    public static void printComp(Comp comp){
        System.out.print("(");

        Fac fac1 = comp.getFac1();
        printFac(fac1);

        Comp_Op compOp = comp.getCompOp();
        System.out.print(" ");
        printCompOp(compOp);
        System.out.print(" ");

        Fac fac2 = comp.getFac2();
        printFac(fac2);

        System.out.print(")");
    }

    public static void printExp(Exp exp){
        Term term = exp.getTerm();
        printTerm(term);

        int choice = exp.getChoice();

        if(choice == 2){
            System.out.print(" + ");
            Exp exp1 = exp.getExp();
            printExp(exp1);
        }else if(choice == 3){
            System.out.print(" - ");
            Exp exp2 = exp.getExp();
            printExp(exp2);
        }
    }

    public static void printTerm(Term term){
        Fac fac1 = term.getFac();
        printFac(fac1);

        int choice = term.getChoice();

        if(choice == 2){
            System.out.print(" * ");
            Term term1 = term.getTerm();
            printTerm(term1);
        }
    }

    public static void printFac(Fac fac){
        int choice = fac.getChoice();

        if(choice == 1){
            int num = fac.getInt();
            System.out.print(num);
        }else if(choice == 2){
            Id id = fac.getId();
            printId(id);
        }else if(choice == 3){
            System.out.print("(");

            Exp exp = fac.getExp();
            printExp(exp);

            System.out.print(")");
        }else{
            System.out.println("Error printing Fac ");
            System.exit(3);
        }
    }

    public static void printCompOp(Comp_Op compOp){
        String co = compOp.getCompOp();
        System.out.print(co);
    }

    public static void printId(Id id){
        String i = id.getId();
        System.out.print(i);
    }
}
