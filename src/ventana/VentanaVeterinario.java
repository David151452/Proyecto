package ventana;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Veterinario;

/*
 * @author David Bravo
 * @author Solange Soto
 * @author Orlando Mendoza
 * @author Lucianno Valdebenito
 */

//Hereda de JFrame.
public class VentanaVeterinario extends javax.swing.JFrame {

    //Atributos clase
    private DefaultTableModel dfTabla;
    /*
    *Se crean objetos para almacenar los atributos de los veterinarios
    *para luego mostrarlos por la tabla.
    */
    private Object[] o1 = new Object[8];
    private Object[] o2 = new Object[8];
    private Object[] o3 = new Object[8];
    private Object[] o4 = new Object[8];
    private ArrayList<Veterinario> veterinarios;

    public ArrayList getVeterinarios() {
        veterinarios = new ArrayList<Veterinario>();
        return veterinarios;
    }

    public VentanaVeterinario() {
        //Cambiar el icono de la aplicación que se encuentra arriba la izquierda
        setIconImage(new ImageIcon(getClass().getResource("/Vetpeticono.png")).getImage());
        initComponents();
        veterinarios = new ArrayList();
        dfTabla = new DefaultTableModel();
        //A cada una de las columnas de la tabla se le agrega los parametros de un Veterinario
        dfTabla.addColumn("Nombre");
        dfTabla.addColumn("Edad");
        dfTabla.addColumn("Teléfono");
        dfTabla.addColumn("Rut");
        dfTabla.addColumn("Especialidad");
        dfTabla.addColumn("Dirección");
        dfTabla.addColumn("Precio de consulta");
        dfTabla.addColumn("Correo");
        Tabla.setModel(dfTabla);
        //Base da datos para que en la tabla mostrada se encuentren 3 vetetinarios ya ingresados.
        Veterinario v1 = new Veterinario("Pedro", 26, "9876578", "21.821.572-2", "Buenas", "Perro", "Arturo perez canto #500", 10000, "Vetpet@gmail.com");
        veterinarios.add(v1);
        o2[0] = "Pedro";
        o2[1] = 26;
        o2[2] = "9876578";
        o2[3] = "21.821.572-2";
        o2[4] = "Perro";
        o2[5] = "Arturo perez canto #500";
        o2[6] = 10000;
        o2[7] = "Vetpet@gmail.com";
        dfTabla.addRow(o2);
        Veterinario v2 = new Veterinario("Matias", 43, "9856785", "87.987.987-9", "Buenas", "Gato", "Acceso s/n Lautaro", 12000, "Feliz@gmail.com");
        veterinarios.add(v2);
        o3[0] = "Matias";
        o3[1] = 43;
        o3[2] = "9856785";
        o3[3] = "87.987.987-9";
        o3[4] = "Gato";
        o3[5] = "Acceso s/n Lautaro";
        o3[6] = 12000;
        o3[7] = "Feliz@gmail.com";
        dfTabla.addRow(o3);
        Veterinario v3 = new Veterinario("Orlando", 32, "98754578", "87.876.879-1", "Buenas", "Caballo", "Escala 651 Lautaro", 7000, "Animal@gmail.com");
        veterinarios.add(v3);
        o4[0] = "Orlando";
        o4[1] = 32;
        o4[2] = "98754578";
        o4[3] = "87.876.879-1";
        o4[4] = "Caballo";
        o4[5] = "Escala 651 Lautaro";
        o4[6] = 7000;
        o4[7] = "Animal@gmail.com";
        dfTabla.addRow(o4);
    }

    public void llenarTabla(Veterinario a) {
        /*
        *Obtenemos cada uno de los datos del anadirVeterinario
        *y los guardamos dentro de o1 para luego agregarlos a la tabla mediante
        *dfTabla.addRow(o1)
        */
        
        this.veterinarios.add(a);
        o1[0] = a.getNombre();
        o1[1] = a.getEdad();
        o1[2] = a.getTelefono();
        o1[3] = a.getRut();
        o1[4] = a.getEspecialidad();
        o1[5] = a.getDireccion();
        o1[6] = a.getPrecio();
        o1[7] = a.getCorreo();
        dfTabla.addRow(o1);
    }

    public void eliminarVeterinario() {
        int fila = this.Tabla.getSelectedRow();//Obtengo id fila seleccionada
        if (fila >= 0) {
            this.veterinarios.remove(fila); //Se elimina del arraylist el veterinario seleccionado en el id de fila
            dfTabla.removeRow(fila); //Se elimina la fila de la tabla
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un veterinario a eliminar porfavor");
        }
    }

    public void modificarVeterinario() {
        int fila = this.Tabla.getSelectedRow();//Obtengo id fila seleccionada
        if (fila >= 0) {
            /*Dentro de los TextField se rellena con los datos de la tabla,
            *,mediante getValueAt(Corresponde a fila,Corresponde a columna),
            *las columnas se definen segun la posición en al cual se encuentra el parametro
             */
            NombreTF.setText(Tabla.getValueAt(fila, 0).toString());
            EdadTF.setText(Tabla.getValueAt(fila, 1).toString());
            TelefonoTF.setText(Tabla.getValueAt(fila, 2).toString());
            RutTF.setText(Tabla.getValueAt(fila, 3).toString());
            EspecialidadTF.setText(Tabla.getValueAt(fila, 4).toString());
            DireccionTF.setText(Tabla.getValueAt(fila, 5).toString());
            PrecioTF.setText(Tabla.getValueAt(fila, 6).toString());
            CorreoTF.setText(Tabla.getValueAt(fila, 7).toString());
            dfTabla.removeRow(fila);
            veterinarios.remove(fila);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un veterinario a modificar porfavor");
        }
    }

    public Veterinario anadirVeterinario() {
        //Obtener los datos del veterinario y guardarlos en sus variables correspondientes de tipo veterinario
        Veterinario vet1 = new Veterinario();
        vet1.setNombre(this.NombreTF.getText());
        vet1.setEdad(Integer.parseInt(this.EdadTF.getText()));
        vet1.setTelefono(this.TelefonoTF.getText());
        vet1.setRut(this.RutTF.getText());
        vet1.setEspecialidad(this.EspecialidadTF.getText());
        vet1.setDireccion(this.DireccionTF.getText());
        vet1.setPrecio(Integer.parseInt(this.PrecioTF.getText()));
        vet1.setCorreo(this.CorreoTF.getText());
        //Al momento de añadir un veterinario eliminar los campos de texto para que queden vacios.
        this.NombreTF.setText("");
        this.EdadTF.setText("");
        this.TelefonoTF.setText("");
        this.RutTF.setText("");
        this.EspecialidadTF.setText("");
        this.DireccionTF.setText("");
        this.PrecioTF.setText("");
        this.CorreoTF.setText("");
        return vet1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        EspecialidadLB = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        AgregarBTN = new javax.swing.JButton();
        EliminarBTN = new javax.swing.JButton();
        NombreTF = new javax.swing.JTextField();
        EdadTF = new javax.swing.JTextField();
        TelefonoTF = new javax.swing.JTextField();
        RutTF = new javax.swing.JTextField();
        EspecialidadTF = new javax.swing.JTextField();
        DireccionTF = new javax.swing.JTextField();
        PrecioTF = new javax.swing.JTextField();
        CorreoTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        ModificarBTN = new javax.swing.JButton();
        InicioBTN = new javax.swing.JButton();
        SalirBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ingrese información del veterinario nuevo:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Edad:");

        jLabel4.setText("Telefono:");

        jLabel5.setText("Rut:");

        EspecialidadLB.setText("Especialidad:");

        jLabel7.setText("Dirección:");

        jLabel8.setText("Precio de la consulta:");

        jLabel9.setText("Correo:");

        AgregarBTN.setText("Agregar");
        AgregarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarBTNActionPerformed(evt);
            }
        });

        EliminarBTN.setText("Eliminar");
        EliminarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarBTNActionPerformed(evt);
            }
        });

        RutTF.setToolTipText("");

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Tabla);

        ModificarBTN.setText("Modificar");
        ModificarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarBTNActionPerformed(evt);
            }
        });

        InicioBTN.setText("Inicio");
        InicioBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioBTNActionPerformed(evt);
            }
        });

        SalirBTN.setText("Salir");
        SalirBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(EspecialidadLB)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9))
                            .addGap(31, 31, 31)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(NombreTF)
                                .addComponent(EdadTF)
                                .addComponent(TelefonoTF)
                                .addComponent(RutTF)
                                .addComponent(EspecialidadTF)
                                .addComponent(DireccionTF)
                                .addComponent(PrecioTF)
                                .addComponent(CorreoTF, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(InicioBTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ModificarBTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EliminarBTN)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SalirBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AgregarBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(NombreTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(EdadTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TelefonoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(RutTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EspecialidadLB)
                            .addComponent(EspecialidadTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(DireccionTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(PrecioTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(CorreoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AgregarBTN)
                    .addComponent(EliminarBTN)
                    .addComponent(ModificarBTN)
                    .addComponent(InicioBTN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SalirBTN)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarBTNActionPerformed
        llenarTabla(anadirVeterinario());

    }//GEN-LAST:event_AgregarBTNActionPerformed

    private void EliminarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarBTNActionPerformed
        eliminarVeterinario();

    }//GEN-LAST:event_EliminarBTNActionPerformed

    private void ModificarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarBTNActionPerformed
        modificarVeterinario();
    }//GEN-LAST:event_ModificarBTNActionPerformed

    private void InicioBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioBTNActionPerformed
        VentanaInicio inicio = new VentanaInicio(veterinarios);
        inicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_InicioBTNActionPerformed

    private void SalirBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirBTNActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirBTNActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarBTN;
    private javax.swing.JTextField CorreoTF;
    private javax.swing.JTextField DireccionTF;
    private javax.swing.JTextField EdadTF;
    private javax.swing.JButton EliminarBTN;
    private javax.swing.JLabel EspecialidadLB;
    private javax.swing.JTextField EspecialidadTF;
    private javax.swing.JButton InicioBTN;
    private javax.swing.JButton ModificarBTN;
    public javax.swing.JTextField NombreTF;
    private javax.swing.JTextField PrecioTF;
    private javax.swing.JTextField RutTF;
    private javax.swing.JButton SalirBTN;
    private javax.swing.JTable Tabla;
    private javax.swing.JTextField TelefonoTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
