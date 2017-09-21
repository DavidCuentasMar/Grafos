/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 *
 * @author dacuentas
 */
public class Ventana extends javax.swing.JFrame {

    /**
     * Creates new form Ventana
     */
    ArrayList<Nodo> nodos;
    ArrayList<Arco> arcos;
    int cantNodos = 0;
    String [][] matrizAd;
    Nodo nodoinicial = null, nodofinal = null;
    int tamNodos = 20;
    int[][] matriz;
   
    public Ventana() {
        initComponents();
        nodos = new ArrayList<>();
        arcos = new ArrayList<>();
        Insertar(jPanel1.getGraphics());
    }
    private int distancia (int x1, int x2, int y1, int y2){
        double dist = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
        return (int)dist;
    }
    private void Insertar(Graphics g){
        jPanel1.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jRadioButton1.isSelected()) {
                    g.setColor(Color.black);
                    g.fillOval(e.getX() - (tamNodos/2), e.getY()-(tamNodos/2), tamNodos, tamNodos);
                    nodos.add(new Nodo(cantNodos+1,e.getX() - (tamNodos/2),e.getY()- (tamNodos/2),Color.BLACK));
                    g.setColor(Color.yellow);
                    g.drawString(Integer.toString(cantNodos+1), e.getX()-3, e.getY()+4);
                    cantNodos++;
                }else{
                    if(nodoinicial == null){
                        nodoinicial = BuscarNodo(e.getX(), e.getY());
                        if (nodoinicial!=null) {
                            seleccionarNodo(nodoinicial, g, Color.red);
                        }
                    }else{
                        nodofinal = BuscarNodo(e.getX(), e.getY());
                        if (nodofinal!=null) {
                            seleccionarNodo(nodofinal, g, Color.red);
                            if (nodofinal.name != nodoinicial.name) {
                                g.setColor(Color.black);
                                g.drawLine(nodoinicial.posx + (tamNodos/2), nodoinicial.posy + (tamNodos/2)
                                        , nodofinal.posx + (tamNodos/2), nodofinal.posy + (tamNodos/2));
                                int distancia = distancia(nodoinicial.posx + (tamNodos/2), nodofinal.posx + (tamNodos/2),nodoinicial.posy + (tamNodos/2),nodofinal.posy + (tamNodos/2));
                                arcos.add(new Arco(nodoinicial.name, nodofinal.name, nodoinicial.posx + (tamNodos/2), 
                                        nodoinicial.posy + (tamNodos/2) , nodofinal.posx + (tamNodos/2), nodofinal.posy + (tamNodos/2), distancia));
                                System.out.println("distancia: " + distancia);
                            }else{
                                seleccionarNodo(nodoinicial, g, Color.black);
                            }
                            seleccionarNodo(nodoinicial, g, Color.black);
                            seleccionarNodo(nodofinal, g, Color.black);
                            nodoinicial=null;
                        }else{
                            seleccionarNodo(nodoinicial, g, Color.black);
                            nodoinicial=null;
                        }
                    }
                    
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        
        });
    
    
    }
    
    private void seleccionarNodo(Nodo nodo, Graphics g, Color color){
        g.setColor(color);
        g.drawOval(nodo.posx, nodo.posy, tamNodos-1, tamNodos-1);
    
    
    }
    private Nodo BuscarNodo(int coordx, int coordy){
        Nodo nodoReturn= null;
        for (Nodo nodo : nodos) {
            if (coordx  >= nodo.posx && coordx <= nodo.posx + tamNodos 
                    && coordy >= nodo.posy && coordy <= nodo.posy + tamNodos) {
                nodoReturn = nodo;
                break;
            }
        }
        
        return nodoReturn;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 238, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Nodo");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Arco");

        jButton1.setText("Matriz de Adyacencia");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 204, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /**if (cantNodos!=0) {
            matrizAd = new String[cantNodos+1][cantNodos+1];            
            int mX=1, mY=1;
            //System.out.println(cantNodos);
            for (Nodo nodo : nodos) {
                matrizAd[mX][0] = nodo.name+"";
                matrizAd[0][mY] = nodo.name+"";
                mX++; mY++;
            }
            for (int x=0; x < matrizAd. length; x++) {
                for (int y=0; y < matrizAd[x]. length; y++) {
                    if (x>0 && y>0 || x==0 & y==0) {
                        System.out.print ("("+matrizAd[x][y]+")"); 
                    }else{
                        System.out.print ("["+matrizAd[x][y]+"]");                  
                    }
                }
                System.out.println("");
            }
            System.out.println(arcos.size());
            for (Arco arco : arcos) {
                for (int i = 0; i < matrizAd.length; i++) {
                    if (arco.nodoinicial==i) {
                        for (int j = 0; j < matrizAd.length; j++) {                       
                            if (arco.nodofinal==j) {
                                matrizAd[i][j]="*";
                                matrizAd[j][i]="*";
                            }
                        }                        
                    }                    
                }
                
            }
            for (int x=0; x < matrizAd. length; x++) {
                for (int y=0; y < matrizAd[x]. length; y++) {
                    if (matrizAd[x][y]==null) {
                        matrizAd[x][y]="0";
                    }
                    if (x>0 && y>0 || x==0 & y==0) {
                        System.out.print ("("+matrizAd[x][y]+")"); 
                    }else{
                        System.out.print ("["+matrizAd[x][y]+"]");                  
                    }
                }
                System.out.println("");
            }
            
        }else{
            System.out.println("No hay nodos");
        }*/
        calcularMatriz();
        Prim(matriz);
    }//GEN-LAST:event_jButton1ActionPerformed
    private void calcularMatriz(){
        System.out.println(nodos.size());
    matriz = new int[nodos.size()][nodos.size()];
        for (Arco arco: arcos) {
            System.out.println(arco.nodofinal);
            matriz[arco.nodoinicial-1][arco.nodofinal-1]=arco.distancia;
            matriz[arco.nodofinal-1][arco.nodoinicial-1]=arco.distancia;
        }
    
    }
    public void Prim(int[][] matriz){
        boolean vector[] = new boolean[nodos.size()];
        vector[0] = true;
        while(todosSeleccionados(vector)){
            int min = menor(matriz, vector);
            vector[min] = true;
        }
    }
    private int menor(int[][] matriz, boolean[] vector){
        int menor = Integer.MAX_VALUE;
        int fila = -1, col = -1;
        for (int i = 0; i < matriz.length; i++) {
            if(vector[i]){
                for (int j = 0; j < matriz.length; j++) {
                    if (matriz[j][i]!=0 && vector[j]==false && matriz[j][i]<=menor) {
                        menor= matriz[j][i];
                        fila=j;
                        col = i;
                    }
                }
            }
        }
        System.out.println("" + fila + " - " + col);
        return fila;
    }
    private Boolean todosSeleccionados(boolean[] vector){
        for (int i = 0; i < vector.length; i++) {
            if (!vector[i]) {
                return true;
            }
        }
        return false;
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    // End of variables declaration//GEN-END:variables
}
