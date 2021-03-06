/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Andres version 1.0
 */
public class ETeatro extends Empleado {

    private char categoria;
    //Modela la categoria del empleado entre A,B,C o D
    private Grupo grupo;

    public ETeatro() {
        super();
    }

    public ETeatro(Empleado e) {
        super(e);
    }

    public ETeatro(Empleado e, char c, Grupo g) {
        super(e);
        this.categoria = c;
        this.grupo = g;

    }

    public ETeatro(ETeatro a) {
        super(a);
        this.categoria = a.getCategoria();

    }

    public ETeatro(long id, String nombre, String apellidos, String nif, String direccion, String telefono, int horastrabajadas, double salarioporhora, double salariomensual, char categoria, Grupo grupo) {
        super(id, nombre, apellidos, nif, direccion, telefono, horastrabajadas, salarioporhora, salariomensual);
        this.categoria = categoria;
        this.grupo = grupo;
    }

    public static ETeatro nuevoETeatro() {
        char z='f';
        char d='d';
        Scanner in;
        char a='s';
        ETeatro eteatro;
        Grupo grupo;
        in = new Scanner(System.in);
        do {
            eteatro = new ETeatro(Empleado.nuevoEmpleado());
            System.out.println("Mete tu categoria");
            a = in.next().charAt(0);
            eteatro.setCategoria(a);
            System.out.println("quieres asignar un grupo a esta este empleado de teatro");
            z = in.next().charAt(0);
            if (z == 's' || z == 'S') {
                grupo = Grupo.nuevogrupo();
                eteatro.setGrupo(grupo);
            } else {
                System.out.println("No has asiganado un grupo a esta este empleado de teatro");
            }

            System.out.println("¿Los datos son correctos?" + eteatro);

            System.out.println("Si lo son pulse s para continuar de lo contrario pulse n");
            d = in.next().charAt(0);
        } while (d != 's' && d != 'S');

        return eteatro;

    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public ETeatro getETeatroById(long id) {

        ETeatro et = null;
        /* for(int i=0; i< Lista.size (); i++){
     et=(Eteatro) Lista[i];
     
        if( f.getId()== Id){
        }
        
     } 
         */
        return et;
    }

    public ArrayList<ETeatro> getAllEsTeatro() {
        ArrayList<ETeatro> EsTeatro = new ArrayList();
        /*for (int i=0; i< Lista.size(); i++)
           f= ETeatro Lista[i];
        EsTeatro.add(f);
       
         */
        return EsTeatro;
    }

    @Override
    public String toString() {
        return "ETeatro{" + "categoria=" + categoria + ", grupo=" + grupo + '}';
    }

    public String data() {
        return super.data() + "|" + getCategoria() + "|" + getGrupo();
    }
}
