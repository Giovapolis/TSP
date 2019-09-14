package Ventanas;

import AG.Ciudad;
import AG.Individuo;
import AG.TSP;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Ventana extends javax.swing.JFrame {

    ArrayList<Ciudad> ciudades = new ArrayList<>();

    public Ventana() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plano = new javax.swing.JPanel();
        btn_aleatorio = new javax.swing.JButton();
        btn_iniciar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        generaciones = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        mutacion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        individuos = new javax.swing.JTextField();
        btn_reinicio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mejores = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TSP");
        setResizable(false);

        plano.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        plano.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                planoMouseClicked(evt);
            }
        });
        plano.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                planoPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout planoLayout = new javax.swing.GroupLayout(plano);
        plano.setLayout(planoLayout);
        planoLayout.setHorizontalGroup(
            planoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );
        planoLayout.setVerticalGroup(
            planoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btn_aleatorio.setText("AGREGAR ALEATORIAMENTE");
        btn_aleatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aleatorioActionPerformed(evt);
            }
        });

        btn_iniciar.setText("INICIAR");
        btn_iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciarActionPerformed(evt);
            }
        });

        jLabel1.setText("Generaciones:");

        generaciones.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("% Mutacion:");

        mutacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mutacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mutacionActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("# Individuos:");

        individuos.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btn_reinicio.setText("REINICIAR");
        btn_reinicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reinicioActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(mejores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_aleatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_iniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mutacion)
                            .addComponent(generaciones)
                            .addComponent(individuos)))
                    .addComponent(btn_reinicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_aleatorio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(generaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mutacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(individuos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_reinicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_iniciar))
                    .addComponent(plano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void planoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_planoMouseClicked
        dibujarPuntoClic(evt.getX(), evt.getY());
    }//GEN-LAST:event_planoMouseClicked

    private void btn_aleatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aleatorioActionPerformed
        dibujarPuntosAleatorios(Integer.parseInt(JOptionPane.showInputDialog("¿Cuantas ciudades deseas agregar?")));
    }//GEN-LAST:event_btn_aleatorioActionPerformed

    private void btn_iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciarActionPerformed
        plano.getGraphics().clearRect(1, 1, plano.getWidth() - 3, plano.getHeight() - 3);
        dibujarCiudades();
        TSP[] Hilos = new TSP[4];
        for (int i = 0; i < Hilos.length; i++) {
            Hilos[i] = new TSP(ciudades,
                    Integer.parseInt(generaciones.getText()),
                    Double.parseDouble(mutacion.getText()),
                    Integer.parseInt(individuos.getText())
            );
            Hilos[i].start();
        }
        for (int i = 0; i < Hilos.length; i++) {
            try {
                Hilos[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        DefaultListModel ModeloLista = new DefaultListModel();
        ArrayList<Individuo> mejores = new ArrayList<>();
        for (TSP Hilo : Hilos) {
            mejores.add(Hilo.getPoblacion().get(Hilo.obtenerMejor(Hilo.getPoblacion())));
            ModeloLista.addElement(Hilo.getPoblacion().get(Hilo.obtenerMejor(Hilo.getPoblacion())));
            this.mejores.setModel(ModeloLista);
        }
        
        dibujarRuta(mejores.get(Hilos[0].obtenerMejor(mejores)).getRuta());
        JOptionPane.showMessageDialog(null, "Mejor De Mejores:\n" + mejores.get(Hilos[0].obtenerMejor(mejores)));
    }//GEN-LAST:event_btn_iniciarActionPerformed

    private void mutacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mutacionActionPerformed

    }//GEN-LAST:event_mutacionActionPerformed

    private void btn_reinicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reinicioActionPerformed
        plano.getGraphics().clearRect(1, 1, plano.getWidth() - 3, plano.getHeight() - 3);
        dibujarCiudades();
    }//GEN-LAST:event_btn_reinicioActionPerformed

    private void planoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_planoPropertyChange

    }//GEN-LAST:event_planoPropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aleatorio;
    private javax.swing.JButton btn_iniciar;
    private javax.swing.JButton btn_reinicio;
    private javax.swing.JTextField generaciones;
    private javax.swing.JTextField individuos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> mejores;
    private javax.swing.JTextField mutacion;
    private javax.swing.JPanel plano;
    // End of variables declaration//GEN-END:variables

    private void dibujarPuntoClic(int x, int y) {
        plano.getGraphics().setColor(Color.BLUE);
        ciudades.add(new Ciudad(x, y, String.valueOf(ciudades.size())));
        plano.getGraphics().fillOval(x, y, 10, 10);
    }

    private void dibujarPuntosAleatorios(int numero) {
        Random R = new Random();
        plano.getGraphics().setColor(Color.BLUE);
        for (int i = 0; i < numero; i++) {
            int x = R.nextInt(plano.getWidth() - 10);
            int y = R.nextInt(plano.getHeight() - 10);
            ciudades.add(new Ciudad(x, y, String.valueOf(ciudades.size())));
            plano.getGraphics().fillOval(x, y, 10, 10);
        }
    }

    private void dibujarRuta(ArrayList<Ciudad> ruta) {
        for (int i = 0; i < ruta.size() - 1; i++) {
            plano.getGraphics().setColor(Color.RED);
            plano.getGraphics().drawLine(ruta.get(i).getX(), ruta.get(i).getY(), ruta.get(i + 1).getX(), ruta.get(i + 1).getY());
        }
        plano.getGraphics().setColor(Color.RED);
        plano.getGraphics().drawLine(ruta.get(ruta.size() - 1).getX(), ruta.get(ruta.size() - 1).getY(), ruta.get(0).getX(), ruta.get(0).getY());
    }

    private void dibujarCiudades() {
        for (Ciudad ciudad : ciudades) {
            super.getGraphics().setColor(Color.BLUE);
            plano.getGraphics().fillOval(ciudad.getX(), ciudad.getY(), 10, 10);
            plano.getGraphics().drawString(ciudad.getNumero(), ciudad.getX(), ciudad.getX());
        }
    }
}
