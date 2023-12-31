/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Controllers.EstacionamientoCtrl;
import TOs.EstacionamientoTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yeider
 */
public class EstacionamientoView extends javax.swing.JPanel {

    /**
     * Creates new form EstacionamientoView
     */
    public EstacionamientoView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOcupar = new javax.swing.JToggleButton();
        btnVaciar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnListarVacios = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        inputNumero = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        btnOcupar.setText("Ocupar");
        btnOcupar.setActionCommand("Listar");
        btnOcupar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOcuparActionPerformed(evt);
            }
        });

        btnVaciar.setText("Vaciar");
        btnVaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.setActionCommand("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnListarVacios.setText("Listar Vacios");
        btnListarVacios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarVaciosActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Numero", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        jButton1.setText("Listar Ocupados");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        inputNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputNumeroKeyTyped(evt);
            }
        });

        jLabel1.setText("Nro. Estacionamiento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOcupar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVaciar))
                    .addComponent(btnListarVacios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputNumero)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOcupar)
                    .addComponent(btnVaciar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListarVacios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOcuparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOcuparActionPerformed
        EstacionamientoCtrl estacionamiento = new EstacionamientoCtrl();
        boolean verificador = estacionamiento.ocupar();
        
        if (verificador) {
            JOptionPane.showMessageDialog(btnEliminar, "Estacionamiento ocupado con exito");
        } else {
            JOptionPane.showMessageDialog(btnEliminar, "No hay estacionamientos libres");
        }
    }//GEN-LAST:event_btnOcuparActionPerformed

    private void btnVaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciarActionPerformed
        EstacionamientoCtrl estacionamiento = new EstacionamientoCtrl();
        boolean verificador = estacionamiento.vaciar();
        
        if (verificador) {
            JOptionPane.showMessageDialog(btnEliminar, "Estacionamiento vaciado con exito");
        } else {
            JOptionPane.showMessageDialog(btnEliminar, "No hay estacionamientos ocupados");
        }
    }//GEN-LAST:event_btnVaciarActionPerformed

    private void btnListarVaciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarVaciosActionPerformed
        EstacionamientoCtrl estacionamiento = new EstacionamientoCtrl();
        ArrayList<EstacionamientoTO> estacionamientos =  estacionamiento.estacionamientosVacios();
        
        DefaultTableModel dataTabla = (DefaultTableModel) tabla.getModel();
        dataTabla.setRowCount(0);
        
        for (EstacionamientoTO estacionamientoTo : estacionamientos) {
            String estado;
            if (estacionamientoTo.getEstado()) estado = "Ocupado";
            else estado = "Vacio";
            dataTabla.addRow(new Object[]{estacionamientoTo.getNumero(), estado});
        }
    }//GEN-LAST:event_btnListarVaciosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        EstacionamientoCtrl estacionamiento = new EstacionamientoCtrl();
        ArrayList<EstacionamientoTO> estacionamientos =  estacionamiento.estacionamientosOcupados();
        
        DefaultTableModel dataTabla = (DefaultTableModel) tabla.getModel();
        dataTabla.setRowCount(0);
        
        for (EstacionamientoTO estacionamientoTo : estacionamientos) {
            String estado;
            if (estacionamientoTo.getEstado()) estado = "Ocupado";
            else estado = "Vacio";
            dataTabla.addRow(new Object[]{estacionamientoTo.getNumero(), estado});
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (!inputNumero.getText().equals("")) {
            EstacionamientoCtrl estacionamiento = new EstacionamientoCtrl();
            estacionamiento.agregar(Integer.parseInt( inputNumero.getText()));
            inputNumero.setText("");
            JOptionPane.showMessageDialog(btnEliminar, "Estacionamiento creado con exito!");
        } else {
            JOptionPane.showMessageDialog(btnEliminar, "Para agregar un estacionamiento debe digitar el numero que tendra dicho estacionamiento");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void inputNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputNumeroKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }
    }//GEN-LAST:event_inputNumeroKeyTyped

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (!inputNumero.getText().equals("")) {
            EstacionamientoCtrl estacionamiento = new EstacionamientoCtrl();
            estacionamiento.eliminar(Integer.parseInt( inputNumero.getText()));
            inputNumero.setText("");
            JOptionPane.showMessageDialog(btnEliminar, "Estacionamiento eliminado con exito!");
        } else {
            JOptionPane.showMessageDialog(btnEliminar, "Para eliminar un estacionamiento debe digitar el numero de dicho estacionamiento");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListarVacios;
    private javax.swing.JToggleButton btnOcupar;
    private javax.swing.JButton btnVaciar;
    private javax.swing.JTextField inputNumero;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
