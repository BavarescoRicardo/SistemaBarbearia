/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import bd.FaturamentoBd;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import modelo.Faturamento;

/**
 *
 * @author Ricardo
 */
public class TelaMensal extends javax.swing.JFrame {
    private DefaultTableModel dtm,dtm2;
    private float tBruto = 0,tliquido = 0,vCorte = 0,vBarba = 0;
    int qntCortes = 0,qntBarbas = 0;
    private FaturamentoBd faturamentoBD = new FaturamentoBd();
    private List<Faturamento> listaF = new ArrayList<Faturamento>();


    /**
     * Creates new form TelaMensal
     */
    public TelaMensal() {
        initComponents();
        dtm = (DefaultTableModel) tabela.getModel();
        dtm2 = (DefaultTableModel) tabela2.getModel();
        Date data = new Date(Calendar.getInstance().getTime().getTime());
     
        listaF = faturamentoBD.getFaturamento(Calendar.MONTH);
        for(Faturamento f:listaF){
            dtm.insertRow(dtm.getRowCount(), new Object[]{f.getData(),f.getValorCortes(),f.getValorBarbas(),f.getQntCortes(),f.getQntBarbas(),f.getCusto(),f.getValorBebidas(),f.getValorProdutos(),f.getTotalBruto(),f.getTotalLiquido()});
            tBruto += f.getTotalBruto();
            tliquido +=(f.getTotalLiquido());
            qntCortes+= f.getQntCortes();
            qntBarbas+= f.getQntBarbas();
            vCorte += f.getValorCortes();
            vBarba += f.getValorBarbas();
            dtm2.insertRow(dtm2.getRowCount(), new Object[]{f.getData(),f.getQntSobrancelhas(),f.getValorSobrancelhas(),f.getQntQuimica(),f.getValorQuimica() } );
        }
        
        
        totalBruto.setText(String.valueOf(tBruto));
        totalLiquido.setText(String.valueOf(tliquido));
        String strBarba = String.valueOf(qntBarbas);
        String strCortes = String.valueOf(qntCortes);
        totalBarbas.setText(strBarba);
        totalCortes.setText(strCortes);
        valorCortes.setText(String.valueOf(vCorte));
        valorBarbas.setText(String.valueOf(vBarba));
    }
  
    private void attTabela(int mes){
        dtm.setRowCount(0);
        dtm2.setRowCount(0);
        tBruto = 0;
        tliquido = 0;
        qntBarbas = 0;
        qntCortes = 0;
        vBarba = 0;
        vCorte = 0;
        for (int linha = 0; linha < dtm.getRowCount();linha ++){
            dtm.removeRow(linha);
        }
        
        for (int linha = 0; linha < dtm2.getRowCount();linha ++){
            dtm2.removeRow(linha);
        }
        
        Calendar ini = Calendar.getInstance();
        ini.set(Calendar.MONTH,mes);
        java.sql.Date inicio = new Date(ini.getTimeInMillis());
        
        
        dtm = (DefaultTableModel) tabela.getModel();
        dtm2 = (DefaultTableModel) tabela2.getModel();
        Date data = new Date(Calendar.getInstance().getTime().getTime());
     
        listaF = faturamentoBD.getFaturamento(mes);
        for(Faturamento f:listaF){
            dtm.insertRow(dtm.getRowCount(), new Object[]{f.getData(),f.getValorCortes(),f.getValorBarbas(),f.getQntCortes(),f.getQntBarbas(),f.getCusto(),f.getValorBebidas(),f.getValorProdutos(),f.getTotalBruto(),f.getTotalLiquido()});
            tBruto += f.getTotalBruto();
            tliquido +=(f.getTotalLiquido());
            qntCortes+= f.getQntCortes();
            qntBarbas+= f.getQntBarbas();
            vCorte += f.getValorCortes();
            vBarba += f.getValorBarbas();
            dtm2.insertRow(dtm2.getRowCount(), new Object[]{f.getData(),f.getQntSobrancelhas(),f.getValorSobrancelhas(),f.getQntQuimica(),f.getValorQuimica() } );
        }
        
        
        totalBruto.setText(String.valueOf(tBruto));
        totalLiquido.setText(String.valueOf(tliquido));
        String strBarba = String.valueOf(qntBarbas);
        String strCortes = String.valueOf(qntCortes);
        totalBarbas.setText(strBarba);
        totalCortes.setText(strCortes);
        valorCortes.setText(String.valueOf(vCorte));
        valorBarbas.setText(String.valueOf(vBarba));
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnFechar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        totalBruto = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        totalLiquido = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabela2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        totalCortes = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        totalBarbas = new javax.swing.JLabel();
        valorCorte = new javax.swing.JLabel();
        valorCortes = new javax.swing.JLabel();
        valorBarba = new javax.swing.JLabel();
        valorBarbas = new javax.swing.JLabel();
        comboMeses = new componentes.UJComboBox();
        btnSel = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Renda total Cortes", "Renda total Barba", "Quantia de cortes", "Quantia de barbas", "Gastos", "Renda bebidas", "Renda produtos", "Renda bruta", "Renda liquida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setResizable(false);
            tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabela.getColumnModel().getColumn(1).setResizable(false);
            tabela.getColumnModel().getColumn(2).setResizable(false);
            tabela.getColumnModel().getColumn(3).setResizable(false);
            tabela.getColumnModel().getColumn(4).setResizable(false);
            tabela.getColumnModel().getColumn(5).setResizable(false);
            tabela.getColumnModel().getColumn(6).setResizable(false);
            tabela.getColumnModel().getColumn(7).setResizable(false);
            tabela.getColumnModel().getColumn(8).setResizable(false);
            tabela.getColumnModel().getColumn(9).setResizable(false);
        }

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total bruto mensal: ");

        totalBruto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totalBruto.setForeground(new java.awt.Color(255, 255, 255));
        totalBruto.setText("1");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total liquido mensal");

        totalLiquido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totalLiquido.setForeground(new java.awt.Color(255, 255, 255));
        totalLiquido.setText("1");

        tabela2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Sobrancelhas", "Valor sobrancelhas", "Quimica", "Valor quimicas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabela2);
        if (tabela2.getColumnModel().getColumnCount() > 0) {
            tabela2.getColumnModel().getColumn(1).setResizable(false);
            tabela2.getColumnModel().getColumn(2).setResizable(false);
            tabela2.getColumnModel().getColumn(3).setResizable(false);
            tabela2.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14));
        jLabel4.setForeground(new java.awt.Color(-1,true));
        jLabel4.setText("Total de cortes");
        jLabel4.setToolTipText("");

        totalCortes.setFont(new java.awt.Font("Dialog", 0, 14));
        totalCortes.setForeground(new java.awt.Color(-1,true));
        totalCortes.setText("1");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14));
        jLabel6.setForeground(new java.awt.Color(-1,true));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Total barbas");

        totalBarbas.setFont(new java.awt.Font("Dialog", 0, 14));
        totalBarbas.setForeground(new java.awt.Color(-1,true));
        totalBarbas.setText("1");

        valorCorte.setFont(new java.awt.Font("Dialog", 0, 14));
        valorCorte.setForeground(new java.awt.Color(-1,true));
        valorCorte.setText("Valor Cortes");

        valorCortes.setFont(new java.awt.Font("Dialog", 0, 14));
        valorCortes.setForeground(new java.awt.Color(-1,true));
        valorCortes.setText("1");

        valorBarba.setFont(new java.awt.Font("Dialog", 0, 14));
        valorBarba.setForeground(new java.awt.Color(-1,true));
        valorBarba.setText("Valor Barbas");

        valorBarbas.setFont(new java.awt.Font("Dialog", 0, 14));
        valorBarbas.setForeground(new java.awt.Color(-1,true));
        valorBarbas.setText("1");

        comboMeses.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        btnSel.setText("Selecionar");
        btnSel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(valorCorte)
                        .addGap(18, 18, 18)
                        .addComponent(valorCortes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(valorBarba))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalCortes)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalBarbas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorBarbas, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(comboMeses, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSel)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalBruto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(totalLiquido, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(208, 208, 208)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalLiquido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalBruto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(totalCortes)
                            .addComponent(jLabel6)
                            .addComponent(totalBarbas))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(valorCorte)
                                        .addComponent(valorCortes))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(valorBarba)
                                        .addComponent(valorBarbas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboMeses, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnSelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelActionPerformed
        // Atualiza as tabelas de faturamento
        //  conforme o mes selecionado no combo
        // zerar totais
        totalBarbas.setText("0");;
        totalLiquido.setText("0");;
        totalCortes.setText("0");;
        totalBruto.setText("0");;
        int mensal = 0;
        mensal = comboMeses.getSelectedIndex();

        attTabela(mensal);
    }//GEN-LAST:event_btnSelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSel;
    private componentes.UJComboBox comboMeses;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabela;
    private javax.swing.JTable tabela2;
    private javax.swing.JLabel totalBarbas;
    private javax.swing.JLabel totalBruto;
    private javax.swing.JLabel totalCortes;
    private javax.swing.JLabel totalLiquido;
    private javax.swing.JLabel valorBarba;
    private javax.swing.JLabel valorBarbas;
    private javax.swing.JLabel valorCorte;
    private javax.swing.JLabel valorCortes;
    // End of variables declaration//GEN-END:variables
}
