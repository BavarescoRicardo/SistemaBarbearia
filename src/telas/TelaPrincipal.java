/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaPrincipal.java
 *
 * Created on Feb 9, 2019, 9:37:37 PM
 */
package telas;

import bd.AgendaBD;
import bd.BebidasBd;
import bd.ClienteBD;
import bd.DiasBD;
import bd.FaturamentoBd;
import bd.ProdutoBd;
import bd.QuimicaBD;
import bd.ServicoBD;
import java.util.ArrayList;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import modelo.Bebidas;
import modelo.Cliente;
import modelo.Dias;
import modelo.Faturamento;
import modelo.Produto;
import modelo.Quimica;
import modelo.Servico;

/**
 *
 * @author Skynet
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private List<Cliente> listaCliente = new ArrayList<Cliente>();
    private List<Servico> listaServicos = new ArrayList<Servico>();
    private List<Bebidas> listaBebidas = new ArrayList<Bebidas>();
    private List<Produto> listaProdutos = new ArrayList<Produto>();
    private List<Quimica> listaQuimica = new ArrayList<Quimica>();

    private ClienteBD clienteBD = new ClienteBD();
    private ProdutoBd produtoBd = new ProdutoBd();
    private ServicoBD servicoBd = new ServicoBD();
    private QuimicaBD quimicaBD = new QuimicaBD();
    private BebidasBd bebidasBd = new BebidasBd();
    private AgendaBD agendaBD = new AgendaBD();
    private FaturamentoBd faturamentoBd = new FaturamentoBd();

    private TelaAgenda telaAgenda;
    private TelaMensal telaMensal;
    private TelaClientes telaClientes;
    private TelaCadastroProduto telaCadastroProduto;
    private TelaCadastroBebida telaCadastroBebida;
    private TelaDias telaDias;
    private TelaEditarServico telaEditarServico;
    
    private DefaultTableModel dtm;
    private javax.swing.JComboBox comboQuimica, comboProduto, comboBebidas,comboCorte,comboBarba;
   
    
    private boolean cabelo, barba, sobrancelhas,selecionado;
    private Date d = new Date(Calendar.getInstance().getTime().getTime());
    private String[] opcoesCorte = {"Comum","Cortesia","Nenhum"};
    private String[] opcoesBarba = {"Comum","Fixo","Nenhum"};
    /** Creates new form TelaPrincipal */
    public TelaPrincipal() {
        initComponents();        

        dtm = (DefaultTableModel) tabela.getModel();
        listaCliente = clienteBD.getClientes();

        for (Cliente cliente : listaCliente) {
            comboClienteUC.addItem(cliente.getNome());
        }

        // Escolha de bebidas
        listaBebidas = bebidasBd.getBebidas();
        comboBebidas = new JComboBox<String>();
        for (Bebidas bebida : listaBebidas) {
            comboBebidas.addItem(bebida.getDescricao());
        }

        // Escolha de Produto
        listaProdutos = produtoBd.getProdutos();
        comboProduto = new JComboBox<String>();
        for (Produto produto : listaProdutos) {
            comboProduto.addItem(produto.getDescricao());
        }
        // selecionar quimica
        listaQuimica = quimicaBD.getListaQuimica();
        comboQuimica = new JComboBox<String>();
        for (Quimica quimica : listaQuimica) {
            comboQuimica.addItem(quimica.getDescricao());
        }

        comboCorte = new JComboBox<String>();
        for (String opcao:opcoesCorte){
            comboCorte.addItem(opcao);
        }

       comboBarba = new JComboBox<String>();
       for (String opcao : opcoesBarba){
           comboBarba.addItem(opcao);
       }

        dtm.addTableModelListener(tabela);

        tabela.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(comboCorte));
        tabela.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboBarba));
        tabela.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(comboQuimica));
        tabela.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(comboBebidas));
        tabela.getColumnModel().getColumn(8).setCellEditor(new DefaultCellEditor(comboProduto));
        
        // tela aniversarios
        TelaAniversario niver = new TelaAniversario();
        niver.setVisible(true);

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnRelatorio = new javax.swing.JButton();
        btnDias = new javax.swing.JButton();
        btnCadsCliente = new javax.swing.JButton();
        btnCadasProdutos = new javax.swing.JButton();
        btnCadastroBebida = new javax.swing.JButton();
        btnEdservicos = new javax.swing.JButton();
        btnAgenda = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        comboClienteUC = new componentes.UJComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Barbearia");
        setBackground(new java.awt.Color(-4144960,true));
        setFocusCycleRoot(false);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(-12566464,true));

        jLabel1.setFont(new java.awt.Font("MS UI Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Barbearia Country");

        tabela.setBackground(new java.awt.Color(204, 204, 204));
        tabela.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Cliiente", "Corte", "Barba", "Sobrancelhas", "Quimica", "Bebidas", "Un", "Produtos", "Un", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setColumnSelectionAllowed(true);
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);
        tabela.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setResizable(false);
            tabela.getColumnModel().getColumn(1).setResizable(false);
            tabela.getColumnModel().getColumn(7).setResizable(false);
            tabela.getColumnModel().getColumn(7).setPreferredWidth(25);
            tabela.getColumnModel().getColumn(9).setResizable(false);
            tabela.getColumnModel().getColumn(9).setPreferredWidth(25);
            tabela.getColumnModel().getColumn(10).setResizable(false);
        }

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdd.setText("Adicionar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRelatorio.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnRelatorio.setText("Relatorio mensal");
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });

        btnDias.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDias.setText("Outros dias");
        btnDias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiasActionPerformed(evt);
            }
        });

        btnCadsCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCadsCliente.setText("Clientes");
        btnCadsCliente.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnCadsCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadsClienteActionPerformed(evt);
            }
        });

        btnCadasProdutos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCadasProdutos.setText("Cadastro Produtos");
        btnCadasProdutos.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnCadasProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadasProdutosActionPerformed(evt);
            }
        });

        btnCadastroBebida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCadastroBebida.setText("Cadastro Bebida");
        btnCadastroBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroBebidaActionPerformed(evt);
            }
        });

        btnEdservicos.setText("Editar serviços");
        btnEdservicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdservicosActionPerformed(evt);
            }
        });

        btnAgenda.setText("Agendamentos");
        btnAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendaActionPerformed(evt);
            }
        });

        btnFinalizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFinalizar.setText("Finalizar dia");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnRemover.setFont(new java.awt.Font("Dialog", 0, 14));
        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnAtualizar.setFont(new java.awt.Font("Dialog", 0, 14));
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Dialog", 0, 14));
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        comboClienteUC.setAutocompletar(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(comboClienteUC, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(156, 156, 156)
                                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadsCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadasProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(103, 103, 103)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastroBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdservicos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(btnDias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(23, 23, 23)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboClienteUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCadsCliente)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnFinalizar)
                                .addComponent(btnCadastroBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCadasProdutos)
                        .addComponent(btnEdservicos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDias, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        selecionado = true;
        
    }//GEN-LAST:event_tabelaMouseClicked

    private void tabelaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMousePressed
}//GEN-LAST:event_tabelaMousePressed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(comboClienteUC.getSelectedItem() != null && !comboClienteUC.getSelectedItem().equals("Cliente"))
            dtm.insertRow(dtm.getRowCount(), new Object[]{(String) d.toString(), comboClienteUC.getSelectedItem().toString(), null, null, false,null,null,1,null,1,0});
       
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed

        telaMensal = new TelaMensal();
        telaMensal.setVisible(true);

}//GEN-LAST:event_btnRelatorioActionPerformed

    private void btnDiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiasActionPerformed
        telaDias = new TelaDias();
        telaDias.setVisible(true);

}//GEN-LAST:event_btnDiasActionPerformed

    private void btnCadsClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadsClienteActionPerformed
        telaClientes = new TelaClientes();
        telaClientes.setVisible(true);


}//GEN-LAST:event_btnCadsClienteActionPerformed

    private void btnCadasProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadasProdutosActionPerformed
        telaCadastroProduto = new TelaCadastroProduto();
        telaCadastroProduto.setVisible(true);

}//GEN-LAST:event_btnCadasProdutosActionPerformed

    private void btnCadastroBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroBebidaActionPerformed
        telaCadastroBebida = new TelaCadastroBebida();
        telaCadastroBebida.setVisible(true);

}//GEN-LAST:event_btnCadastroBebidaActionPerformed

    private void btnEdservicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdservicosActionPerformed
        // editar servicos
        telaEditarServico = new TelaEditarServico();
        telaEditarServico.setVisible(true);

}//GEN-LAST:event_btnEdservicosActionPerformed

    private void btnAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendaActionPerformed
        telaAgenda = new TelaAgenda();
        telaAgenda.setVisible(true);

}//GEN-LAST:event_btnAgendaActionPerformed
    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        
        // Teste na tabela para ver se existem registros
        // começo faturamento
        Calendar data = Calendar.getInstance().getInstance();
        
          if(dtm.getRowCount() > 0){
            // diario
            fluxoDiario(data);
            //mensal
            fluxoMensal(data);
          }
            
    }//GEN-LAST:event_btnFinalizarActionPerformed


    private void fluxoMensal(Calendar mes){

    float gastos = 0, diaBruto = 0, diaLiquido = 0;
    int n1 = 0;
    int qntCortes = 0;
    int qntBarbas = 0;
    int qntSobrancelhas = 0;
    int qntQuimica = 0;
    listaQuimica = quimicaBD.getListaQuimica();
    float valorCortes = 0, valorBarbas = 0, valorSobrancelhas = 0, valorQuimica = 0, valorBebidas = 0, valorProdutos = 0;


    int idx = dtm.getRowCount();
    for (int cont = 0; cont < idx; cont++) {
            if(tabela.getValueAt(cont, 2) != null){
                if (!tabela.getValueAt(cont, 1).toString().equals("") && !tabela.getValueAt(cont, 2).toString().equals("Nenhum") ) {
                    if (tabela.getValueAt(cont, 2) != null) {
                        qntCortes++;
                        if (tabela.getValueAt(cont, 2).toString().equals("Comum")){
                            valorCortes += servicoBd.getServicos().get(0).getValor();                           
                        }
                       
                    }
                }
            }
        }

        for (int cont = 0; cont < idx; cont++) {
            if(tabela.getValueAt(cont, 3) != null){
                float vale = 0;
                if (tabela.getValueAt(cont, 3)!= null) {
                    if (!tabela.getValueAt(cont, 3).toString().equals("Nenhum"))
                        qntBarbas++;
                    if (tabela.getValueAt(cont, 3).toString().equals("Comum"))
                        vale = (servicoBd.getServicoId(2).getValor());
                    if (tabela.getValueAt(cont, 3).toString().equals("Fixo"))
                        vale = (servicoBd.getServicoId(6).getValor());
                        valorBarbas += vale;
                }
            }
        }

        for (int cont = 0; cont < idx; cont++ ) {
            if (tabela.getValueAt(cont, 4) != null) {
                if (tabela.getValueAt(cont, 4).toString().equals("true")) {
                    qntSobrancelhas++;

                    float vale = (servicoBd.getServicoId(3).getValor());
                    valorSobrancelhas += vale;

                }
            }
        }

        for (int cont = 0; cont < idx; cont++) {
            if (tabela.getValueAt(cont, 5) != null) {
                if (!tabela.getValueAt(cont, 5).toString().equals("nenhuma")) {
                    qntQuimica++;
                    for(Quimica quimica : listaQuimica){
                        if(quimica.getDescricao().equals(dtm.getValueAt(cont, 5))){
                            valorQuimica += quimica.getValor();
                            System.out.println("Encontrou  "+quimica.getDescricao()+"  Com valor de  "+valorQuimica);
                        }
                    }
                    
                    }
                }
        }

        for (int cont = 0; cont < idx; cont++) {
            if (tabela.getValueAt(cont, 6) != null) {
                if (!tabela.getValueAt(cont, 6).equals("Nenhuma")) {
                    gastos += (bebidasBd.getBebidaEspecifica((String) tabela.getValueAt(cont, 6)).getCusto() * Float.parseFloat(tabela.getValueAt(cont, 7).toString()));
                    valorBebidas += (bebidasBd.getBebidaEspecifica((String) tabela.getValueAt(cont, 6)).getPrecoVenda());
                    valorBebidas *= Float.parseFloat(tabela.getValueAt(cont, 7).toString());

                }
            }
        }

        for (int cont = 0; cont < idx; cont++) {
            if (tabela.getValueAt(cont, 8) != null && !tabela.getValueAt(cont, 8).equals("Nenhum")) {
                gastos += (produtoBd.getProdutoEspecifico((String) tabela.getValueAt(cont, 8)).getCusto() * Float.parseFloat(tabela.getValueAt(cont, 9).toString()));
                valorProdutos += (produtoBd.getProdutoEspecifico((String) tabela.getValueAt(cont, 8)).getPrecoVenda() * Float.parseFloat(tabela.getValueAt(cont, 9).toString()));

            }
        }
        for(int linhas = 0; linhas < dtm.getRowCount(); linhas ++){
            if(dtm.getValueAt(linhas, 10) != null)
                diaBruto += Float.parseFloat(dtm.getValueAt(linhas, 10).toString());
        }
        diaLiquido = (diaBruto - gastos);

        // finaliza e salva no banco
        Faturamento faturamento = new Faturamento(d, qntCortes, qntBarbas, qntSobrancelhas, qntQuimica, valorCortes, valorBarbas, valorSobrancelhas, valorQuimica, gastos, valorBebidas, valorProdutos, diaBruto, diaLiquido);
        faturamentoBd.salvaFaturamento(faturamento);

        // limpar tabela

        dtm.setRowCount(0); 
    }


    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if(selecionado == true && dtm.getRowCount() > 0){
            dtm.removeRow(tabela.getSelectedRow());
            selecionado = false;
        }
    }//GEN-LAST:event_btnRemoverActionPerformed
    public void atualizaListas(){
        
    //    for(Cliente cliente:listaCliente){//
            comboClienteUC.removeAllItems();
    //    }
        listaCliente = clienteBD.getClientes();
        for(Cliente cliente:listaCliente){
            comboClienteUC.addItem(cliente.getNome().toString());
        }

        // Atualiza lista de bebidas
        listaBebidas = bebidasBd.getBebidas();
        comboBebidas.removeAllItems();
        for(Bebidas bebida : listaBebidas){
            comboBebidas.addItem(bebida.getDescricao().toString());
        }

        // Atualiza lista de produtos
        listaProdutos = produtoBd.getProdutos();
        comboProduto.removeAllItems();
        for (Produto protudo : listaProdutos){
            comboProduto.addItem(protudo.getDescricao().toString());
        }
    }
    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // atualiza os combos
        atualizaListas();

        // atualiza o valor selecionado

        atualizaValores();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        TelaSair sair = new TelaSair();
        sair.setVisible(true);
    }//GEN-LAST:event_btnSairActionPerformed

    private void fluxoDiario(Calendar d){
        // salvar fluxo diario
        
        int indice = dtm.getRowCount();
        java.sql.Date data = new Date(d.getTimeInMillis());
        Dias dia;
        for (int cont = 0; cont < indice; cont++){
            Cliente cliente = null;
            Produto protudo = new Produto("Nada", 0, 0);
            protudo.setId(1);
            Bebidas bebida = new Bebidas("Nada", 0, 0);
            bebida.setId(1);
            Quimica quimica = new Quimica(1, "Nada", 0);
            int unBebida = 0,unProduto = 0,corteBol = 0,barbaBol = 0,sobrancelhasBol = 0;
            float corte = 0,barba = 0, sobrancelhas = 0,valorQuimica = 0,valorProduto = 0,valorBebida = 0,bruto = 0, liquido = 0;

            if(dtm.getValueAt(cont, 1) != null)
                cliente = clienteBD.getClienteNome(dtm.getValueAt(cont, 1).toString());

            if(dtm.getValueAt(cont, 2) != null){
                if(dtm.getValueAt(cont, 2).toString().equals("Comum")){
                    corte = servicoBd.getServicoId(1).getValor();
                    corteBol = 1;
                }else if(dtm.getValueAt(cont, 2).toString().equals("Cortesia"))
                    corteBol = 2;
            }
            if(dtm.getValueAt(cont, 3) != null && !dtm.getValueAt(cont, 3).equals("Nenhum")){
                if (dtm.getValueAt(cont, 3).equals("Comum"))
                    barba = servicoBd.getServicoId(2).getValor();
                    else if (dtm.getValueAt(cont, 3).equals("Fixo")){
                        barba = servicoBd.getServicoEspecifico("Barba fixo").getValor();
                        System.out.println("fixo");
                    } else
                            barba = 0;

                barbaBol = 1;
            }
            if(dtm.getValueAt(cont, 4).equals(true)){
                sobrancelhas = servicoBd.getServicoId(3).getValor();
                sobrancelhasBol = 1;
            }
            if(dtm.getValueAt(cont, 5) != null){
                if(!dtm.getValueAt(cont, 5).equals("Nenhuma")){
                    quimica = quimicaBD.getQuimicaDesc(dtm.getValueAt(cont, 5).toString());
                    valorQuimica = quimica.getValor();
                }
            }

            if(dtm.getValueAt(cont, 6) != null){
                if(!dtm.getValueAt(cont, 6).toString().equals("Nenhuma")){
                    bebida = bebidasBd.getBebidaEspecifica(dtm.getValueAt(cont, 6).toString());
                    int unidades = Integer.parseInt(dtm.getValueAt(cont, 7).toString());
                    valorBebida = (unidades * bebida.getPrecoVenda());
                    System.out.println("O valor da bebida eh  "+valorBebida);
                    unBebida = unidades;
                    
                }
            }

            if(dtm.getValueAt(cont, 8) != null){
                if(!dtm.getValueAt(cont, 8).toString().equals("Nenhum")){
                    protudo = produtoBd.getProdutoEspecifico(dtm.getValueAt(cont, 8).toString());
                    int unidades = Integer.parseInt(dtm.getValueAt(cont, 9).toString());
                    valorProduto = (unidades * protudo.getPrecoVenda());
                    unProduto = unidades;
                    System.out.println("O valor do produto eh  "+valorProduto);

                }
            }


            bruto = (valorBebida+corte+barba+sobrancelhas+valorQuimica+valorProduto);
            //System.out.println(cliente.getNome()+"  Valores que formam o total  |coere:  "+corte+" Bebida: "+valorBebida+"  Produto: "+valorProduto+"  Barba:  "+barba);
            //salva o fluxo diario
            dia = new Dias(data, cliente, corteBol, barbaBol, sobrancelhasBol, quimica, bebida, unBebida, protudo, unProduto, bruto);
            DiasBD diaBd = new DiasBD();
            diaBd.salvarDia(dia);
        }

    }


    private void atualizaValores(){
        float valorProduto = 0;
        float valorBedida = 0;
        float valorQuimica = 0;
        float valorB = 0;
        float valorS = 0;
        float valorC = 0;
        float total = 0;
        cabelo = false;
        barba = false;
        sobrancelhas = false;
    if(tabela.getRowCount() > 0 && selecionado){
        int idx = tabela.getSelectedRow();
        
            if (tabela.getValueAt(idx, 2)!= null && !tabela.getValueAt(idx, 2).toString().equals("Nenhum")) {
                cabelo = true;
            }   else {
                cabelo = false;
                }
            
        if (tabela.getValueAt(idx, 3)!= null ){
            if (!tabela.getValueAt(idx, 3).toString().equals("Nenhum")) {
                barba = true;
            } else {
                barba = false;
            }
        }
        
            if (tabela.getValueAt(idx, 4).toString().equals("true")) {
                sobrancelhas = true;
            } else {
                sobrancelhas = false;
            }
        
            if (cabelo && (tabela.getValueAt(idx, 2)).toString().equals("Comum") ) {
                valorC = servicoBd.getServicoId(1).getValor();

            } else {
                valorC = 0;
            }
            if (barba){
                if(tabela.getValueAt(idx, 3).toString().equals("Comum")) {
                    valorB = servicoBd.getServicoId(2).getValor();
                }

            else if (tabela.getValueAt(idx, 3).toString().equals("Fixo"))
                valorB = servicoBd.getServicoId(6).getValor();
            } else
                valorB = 0;
            if (sobrancelhas) {
                valorS = servicoBd.getServicoId(3).getValor();
            } else {
                valorS = 0;
            }
            if (tabela.getValueAt(idx, 5) != null) {
                
                if (!tabela.getValueAt(idx, 5).equals("nenhuma")) {
                    for (Quimica quimica : listaQuimica) {
                        if (tabela.getValueAt(idx, 5).toString().equals(quimica.getDescricao())) {
                            valorQuimica += quimica.getValor();
                            break;
                        }
                    }
                
                }
            }

            if (tabela.getValueAt(idx, 6) != null) {
                if(!tabela.getValueAt(idx, 6).equals("Nenhuma")){
                    for (Bebidas b : listaBebidas) {
                        if (b.getDescricao().equals(tabela.getValueAt(idx, 6))) {
                            valorBedida = b.getPrecoVenda();
                            valorBedida *= Integer.parseInt(dtm.getValueAt(idx, 7).toString());
                            break;
                        }
                    }
                }
            }

            if (tabela.getValueAt(idx, 8) != null) {
                if(!tabela.getValueAt(idx, 8).equals("Nenhum")){
                
                for (Produto p : listaProdutos) {
                    if (p.getDescricao().equals(tabela.getValueAt(idx, 8).toString())) {
                        valorProduto = p.getPrecoVenda();
                        valorProduto *= Integer.parseInt(dtm.getValueAt(idx, 9).toString());
                    }
                    }
                }
                
            } else {
                valorProduto = 0;
            }

            total = (valorC + valorB + valorS + valorBedida + valorProduto + valorQuimica);
            tabela.setValueAt(total, idx, 10);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void

main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });


}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAgenda;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadasProdutos;
    private javax.swing.JButton btnCadastroBebida;
    private javax.swing.JButton btnCadsCliente;
    private javax.swing.JButton btnDias;
    private javax.swing.JButton btnEdservicos;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSair;
    private componentes.UJComboBox comboClienteUC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

}
