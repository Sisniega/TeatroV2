package modelos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mario
 * @version 1.1
 */
public class Informe  {

    protected long id;/*Modela id. Valor positivo*/
    private int mes;/*Modela el mes. Valor positivo*/
    private int anio;/*Modela el anio. Valor positivo*/
    private double balance;/*Modela balance. Valor positivo o valor negativo*/
    private Secretariado secretariado;

    public Informe() {

    }

    public Informe(long id, int mes, int anio, double balance) {

        this.id = id;
        this.mes = mes;
        this.anio = anio;
        this.balance = balance;
    }

    public Informe(Informe i) {

        this.id = i.getId();
        this.mes = i.getMes();
        this.anio = i.getAnio();
        this.balance = i.getBalance();
    }

    
    public static Informe nuevoinforme() {
        char d='a';
        Scanner in;
        int mes;
        int año;

        double c;
        Informe i = new Informe();
        Secretariado s ;

        in = new Scanner(System.in);
        char z;
        
        do {
            do {
                System.out.println("Mes de creacion del Informe");

                mes = in.nextInt();

            } while (mes < 1 || mes > 12);
            System.out.println("Año de creacion del Informe");
            año = in.nextInt();

            System.out.println("Introduce el balance en euros");
            c = in.nextDouble();
            System.out.println("quieres asignar un secretario a esta este informe");
            z = in.next().charAt(0);
            if (z == 's' || z == 'S') {
            s = Secretariado.nuevoSecretariado();
            i.setSecretariado(s);}
            else {
                System.out.println("No has asiganado un secretario a esta este informe");}
            
      
       
       System.out.println("¿Los datos son correctos?"+i);
      
      System.out.println("Si lo son pulse s para continuar de lo contrario pulse n");
      d= in.next().charAt(0);
      }
            while (d != 's' && d != 'S');

            return i;

        }

    

    public Informe getInformeById(long Id) {
        Informe i = null;
        /* for(int i=0; i< Lista.size (); i++){
     s=(Beneficio) Lista[i];
     
        if( s.getId()== Id){
        }
        
     } 
         */
        return i;
    }

    public ArrayList<Informe> getAllInformes() {
        ArrayList<Informe> Informes = new ArrayList();
        /*for (int i=0; i< Lista.size(); i++)
           g= Grupo Lista[i];
       Informe.add(f);
       
         */
        return Informes;
    }

    
    public Secretariado getSecretariado() {
        return secretariado;
    }

    
    public void setSecretariado(Secretariado secretariado) {
        this.secretariado = secretariado;
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Informe{" + "id=" + id + ", mes=" + mes + ", anio=" + anio + ", balance=" + balance + ", secretariado=" + secretariado + '}';
    }

  
    public String data() {
        return "" + getId() + "|" + getMes() + "|" + getAnio() + "|" + getBalance() + "|" + getSecretariado();
    }
}
