package com.company;

public class CodeEx1 {
    public static void main(String[] args) {
    IntegerSet a = new IntegerSet();
    a.insertElement(4);
    a.insertElement(5);
    a.insertElement(6);
    a.deleteElement(4);
    a.insertElement(9);
    IntegerSet b = new IntegerSet();
    b.insertElement(3);
    b.insertElement(6);
    IntegerSet c = IntegerSet.union(a,b);
    IntegerSet d = IntegerSet.intersection(a,b);
    a.DisplaySet();
    c.DisplaySet();
    d.DisplaySet();
    }
}

class IntegerSet{
    public boolean[] set;
    IntegerSet(){
        set = new boolean[101];
    }
    public void insertElement(int element){
        if (element>100 || element <0)
            throw new IllegalArgumentException("Integer must e in the range 0-100");
        else
            set[element] = true ;

    }
    public void deleteElement(int element){
        if (element>100 || element <0)
            throw new IllegalArgumentException("Integer must e in the range 0-100");
        else
            set[element] = false ;
    }

    public static IntegerSet union(IntegerSet a,IntegerSet b){
        IntegerSet temp =new IntegerSet();
        for (int i=0;i<101;i++){
            if (a.set[i]==true || b.set[i]==true){
                temp.insertElement(i);
            }
        }
        return temp;
    }
    public static IntegerSet intersection(IntegerSet a,IntegerSet b){
        IntegerSet temp =new IntegerSet();
        for (int i=0;i<101;i++){
            if (a.set[i]==true && b.set[i]==true){
                temp.insertElement(i);
            }
        }
        return temp;
    }

    public boolean isEqual(IntegerSet a,IntegerSet b){
        for (int i=0;i<101;i++){
            if (a.set[i]!=b.set[i]){
                return false;
            }
        }
        return true;
    }
    public void DisplaySet(){
        for (int i=0;i<set.length;i++){
            if(set[i]==true){System.out.print(i+" ");}

        }
        System.out.println();
    }

}
