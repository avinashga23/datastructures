package com.byteobject.prototype.datastructures.symboltable;

public class SymbolTableMain {

    public static void main(String[] args) {
        SymbolTable<Integer, String> symbolTable = new SymbolTable<>();
        symbolTable.put(1, "one");
        symbolTable.put(2, "two");
        symbolTable.put(3, "three");
        symbolTable.put(4, "four");
        symbolTable.put(5, "five");

        System.out.println(symbolTable.get(5));
        System.out.println(symbolTable.get(4));

        symbolTable.put(5, "five updated");
        System.out.println(symbolTable.get(5));
        symbolTable.keys().forEach(System.out::println);
        symbolTable.deleteMin();
        symbolTable.keys().forEach(System.out::println);
        symbolTable.delete(4);
        System.out.println("#######################");
        symbolTable.keys().forEach(System.out::println);
    }

}
