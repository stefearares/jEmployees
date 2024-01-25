package gui;

import employeepack.Employee;
import exceptions.MyException;
import operationsDB.DatabaseMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import static operationsDB.DatabaseMethods.*;


public class GUI  extends JFrame {
    private JLabel eticheta_prenume;
    private JLabel eticheta_nume;
    private JLabel eticheta_CNP;
    private JLabel eticheta_loc_nastere;
    private JLabel eticheta_stare_civila;
    private JLabel eticheta_nationalitate;
    private JLabel eticheta_departament;
    private JLabel eticheta_salariu;
    private JLabel eticheta_marca;
    private JLabel eticheta_functie;
    private JLabel eticheta_numar_telefon;
    private JLabel eticheta_adresa;
    private JLabel eticheta_email;
    private JButton cautare;
    private JButton adaugare;
    private JButton modificare;
    private JButton stergere;
    private JButton refresh;
    private JTextField text_prenume;
    private JTextField text_nume;
    private JTextField text_CNP;
    private JTextField text_salariu;
    private JTextField text_marca;
    private JTextField text_telefon;
    private JTextField text_adresa;
    private JTextField text_email;
    private JTextField text_cautare;
    private JTextField text_loc_nastere;
    private JComboBox optiuni_functie;
    private JComboBox optiuni_stare_civila;
    private JComboBox optiuni_nationalitate;
    private JComboBox optiuni_departament;
    private DefaultListModel<String> model_lista;
    private JOptionPane eroare_cnp;
    private JFrame eroare_adaugare;
    private JList<String> lista_useri;
    private List<Employee> employeeList;
    private List<Employee> lista;
    private JRadioButton ascendingRadio;
    private JRadioButton descendingRadio;
    private ButtonGroup filterGroup;
    private JButton filterButton;

    public GUI(){
        this.setTitle("jEmployees");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700,700);
        this.setLayout(new BorderLayout());

        eticheta_prenume=new JLabel("Prenume:");
        eticheta_nume=new JLabel("Nume:");
        eticheta_adresa=new JLabel("Adresa:");
        eticheta_CNP=new JLabel("CNP:");
        eticheta_email=new JLabel("Email:");
        eticheta_departament=new JLabel("Departament:");
        eticheta_marca=new JLabel("Marca:");
        eticheta_numar_telefon=new JLabel("Numar telefon:");
        eticheta_nationalitate=new JLabel("Nationalitate:");
        eticheta_salariu=new JLabel("Salariu:");
        eticheta_functie=new JLabel("Functie:");
        eticheta_stare_civila=new JLabel("Stare civila:");
        eticheta_loc_nastere=new JLabel("Loc nastere:");

        text_adresa=new JTextField(20);
        text_CNP=new JTextField(20);
        text_email=new JTextField(20);
        text_nume=new JTextField(20);
        text_prenume=new JTextField(20);
        text_salariu=new JTextField(20);
        text_telefon=new JTextField(20);
        text_marca=new JTextField(20);
        text_cautare=new JTextField(20);
        text_cautare.setText("Marca, Nume...");
        text_loc_nastere=new JTextField(20);

        eroare_adaugare=new JFrame();

        eroare_cnp=new JOptionPane();

        String[] lista_departamente={"IT","Logisitca","Productie","Design","Management","Resurse Umane","Marketing","Finante"};
        optiuni_departament=new JComboBox<String>(lista_departamente);
        String[] lista_stari={"Necasatorit","Casatorit","Divortat"};
        optiuni_stare_civila=new JComboBox<String>(lista_stari);
        String[] lista_functii={"Analist","Economist","Manager","Team Leader","Operator","Programator","Expert Marketing","Expert HR"};
        optiuni_functie=new JComboBox<String>(lista_functii);
        String[] lista_nationalitati={"Roman","Maghiar","Moldovean","Sarb","Bulgar","Ucrainean","Austriac","Grec"};
        optiuni_nationalitate=new JComboBox(lista_nationalitati);


        cautare=new JButton("Search");

        cautare.setBackground(Color.GRAY);
        cautare.setForeground(Color.WHITE);
        cautare.setOpaque(true);


        adaugare=new JButton("Add");

        adaugare.setBackground(Color.GREEN);
        adaugare.setForeground(Color.WHITE);
        adaugare.setOpaque(true);


        modificare=new JButton("Modify");

        modificare.setBackground(Color.GRAY);
        modificare.setForeground(Color.WHITE);
        modificare.setOpaque(true);


        stergere=new JButton("Delete");

        stergere.setBackground(Color.RED);
        stergere.setForeground(Color.WHITE);
        stergere.setOpaque(true);

        refresh=new JButton("Refresh");

        refresh.setBackground(Color.GRAY);
        refresh.setForeground(Color.WHITE);
        refresh.setOpaque(true);

        model_lista= new DefaultListModel<>();
        lista_useri=new JList<>(model_lista);
        lista_useri.setBackground(Color.lightGray);
        lista_useri.setForeground(Color.DARK_GRAY);
        employeeList= DatabaseMethods.ListaBD();
        int j=0;
        for(Employee i:employeeList)
        {
            String temp=i.getPrenume()+" "+i.getNume()+" "+i.getMarca();
            model_lista.add(j,temp);
            j++;
        }
        ascendingRadio = new JRadioButton("Ascending");
        descendingRadio = new JRadioButton("Descending");
        filterGroup = new ButtonGroup();
        filterGroup.add(ascendingRadio);
        filterGroup.add(descendingRadio);

        filterButton = new JButton("Filter");
        filterButton.setBackground(Color.BLUE);
        filterButton.setForeground(Color.WHITE);
        filterButton.setOpaque(true);

        JPanel filterPanel = new JPanel();
        filterPanel.add(ascendingRadio);
        filterPanel.add(descendingRadio);
        filterPanel.add(filterButton);

        JPanel panou_useri=new JPanel(new GridLayout(0, 1, 0, 0));
        //panou_useri.setPreferredSize(new Dimension(50,250));
        panou_useri.add(lista_useri);

        JPanel panou_date = new JPanel(new GridLayout(0, 1, 0, 0));
        panou_date.add(eticheta_prenume);
        panou_date.add(text_prenume);
        panou_date.add(eticheta_nume);
        panou_date.add(text_nume);
        panou_date.add(eticheta_marca);
        panou_date.add(text_marca);
        panou_date.add(eticheta_CNP);
        panou_date.add(text_CNP);
        panou_date.add(eticheta_salariu);
        panou_date.add(text_salariu);
        panou_date.add(eticheta_adresa);
        panou_date.add(text_adresa);
        panou_date.add(eticheta_email);
        panou_date.add(text_email);
        panou_date.add(eticheta_numar_telefon);
        panou_date.add(text_telefon);
        panou_date.add(eticheta_loc_nastere);
        panou_date.add(text_loc_nastere);
        panou_date.add(eticheta_departament);
        panou_date.add(optiuni_departament);
        panou_date.add(eticheta_stare_civila);
        panou_date.add(optiuni_stare_civila);
        panou_date.add(eticheta_functie);
        panou_date.add(optiuni_functie);
        panou_date.add(eticheta_nationalitate);
        panou_date.add(optiuni_nationalitate);


        JPanel panou_set=new JPanel();
        //panou_set.setPreferredSize(new Dimension(150,45));
        panou_set.add(adaugare);
        panou_set.add(modificare);
        panou_set.add(stergere);
        panou_set.add(refresh);

        JPanel panou_cautare=new JPanel();
        //panou_cautare.setPreferredSize(new Dimension(150,45));
        panou_cautare.add(text_cautare);
        panou_cautare.add(cautare);

        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.add(panou_cautare, BorderLayout.NORTH);
        northPanel.add(filterPanel, BorderLayout.SOUTH);
        JPanel panou_gol = new JPanel();

        panou_gol.setPreferredSize(new Dimension(10, 10));

        this.add(panou_date,BorderLayout.CENTER);
        //this.add(panou_cautare,BorderLayout.NORTH);
        this.add(panou_useri,BorderLayout.EAST);
        this.add(panou_set,BorderLayout.SOUTH);
        this.add(panou_gol,BorderLayout.WEST);
        this.add(northPanel, BorderLayout.NORTH);

        ActionListener adaugare_bd=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prenume=text_prenume.getText();
                String nume=text_nume.getText();
                String marca=text_marca.getText();
                String cnp=text_CNP.getText();
                int salariu=Integer.parseInt(text_salariu.getText());
                String adresa=text_adresa.getText();
                String email=text_email.getText();
                String numar=text_telefon.getText();
                String loc=text_loc_nastere.getText();
                String dep=String.valueOf(optiuni_departament.getSelectedItem());
                String stare=String.valueOf(optiuni_stare_civila.getSelectedItem());
                String functie=String.valueOf(optiuni_functie.getSelectedItem());
                String nationalitate=String.valueOf(optiuni_nationalitate.getSelectedItem());

                if(CautareBD(cnp,marca)==false)
                {
                    try {
                        Employee temporar=new Employee(prenume,nume,cnp,loc,stare,nationalitate,dep,salariu,marca,functie,numar,adresa,email);
                        DatabaseMethods.AdaugareBD(temporar);
                        text_prenume.setText("");
                        text_nume.setText("");
                        text_marca.setText("");
                        text_CNP.setText("");
                        text_salariu.setText("");
                        text_adresa.setText("");
                        text_email.setText("");
                        text_telefon.setText("");
                        text_loc_nastere.setText("");
                        optiuni_departament.setSelectedItem("IT");
                        optiuni_functie.setSelectedItem("Analist");
                        optiuni_nationalitate.setSelectedItem("Roman");
                        optiuni_stare_civila.setSelectedItem("Necasatorit");
                        eroare_cnp.showMessageDialog(eroare_adaugare,"Successfully added!");
                        model_lista.removeAllElements();
                        employeeList= DatabaseMethods.ListaBD();
                        int j=0;
                        for(Employee i:employeeList)
                        {
                            String temp=i.getPrenume()+" "+i.getNume()+" "+i.getMarca();
                            model_lista.add(j,temp);
                            j++;
                        }

                    }
                    catch (MyException x)
                    {   eroare_cnp.showMessageDialog(eroare_adaugare,"Please check whether the CNP,email or phone number provided are valid.");
                        x.printStackTrace();
                    }
                }
                else {
                    eroare_cnp.showMessageDialog(eroare_adaugare,"Employee already exists!");
                    text_prenume.setText("");
                    text_nume.setText("");
                    text_marca.setText("");
                    text_CNP.setText("");
                    text_salariu.setText("");
                    text_adresa.setText("");
                    text_email.setText("");
                    text_telefon.setText("");
                    text_loc_nastere.setText("");
                    optiuni_departament.setSelectedItem("IT");
                    optiuni_functie.setSelectedItem("Analist");
                    optiuni_nationalitate.setSelectedItem("Roman");
                    optiuni_stare_civila.setSelectedItem("Necasatorit");
                }

            }
        };

        ActionListener stergere_bd=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!lista_useri.isSelectionEmpty()) {
                    String selectedValue = lista_useri.getSelectedValue();
                    String[] temp = selectedValue.split(" ");
                    String marcax = temp[2];
                    StergereBD(marcax);
                    model_lista.removeElement(selectedValue);
                    eroare_cnp.showMessageDialog(eroare_adaugare,"Successfully deleted!");

                } else {
                    eroare_cnp.showMessageDialog(eroare_adaugare,"An employee must be chosen from the list!");

                }
            }
        };

        ActionListener reimprospatare=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model_lista.removeAllElements();
                employeeList= DatabaseMethods.ListaBD();
                int j=0;
                for(Employee i:employeeList)
                {
                    String temp=i.getPrenume()+" "+i.getNume()+" "+i.getMarca();
                    model_lista.add(j,temp);
                    j++;
                }
                text_cautare.setText("Marca, Nume...");
                text_prenume.setText("");
                text_nume.setText("");
                text_marca.setText("");
                text_CNP.setText("");
                text_salariu.setText("");
                text_adresa.setText("");
                text_email.setText("");
                text_telefon.setText("");
                text_loc_nastere.setText("");
                optiuni_departament.setSelectedItem("IT");
                optiuni_functie.setSelectedItem("Analist");
                optiuni_nationalitate.setSelectedItem("Roman");
                optiuni_stare_civila.setSelectedItem("Necasatorit");
            }
        };
        ActionListener cautare_bd=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cautare=text_cautare.getText();
                lista= DatabaseMethods.CautareBDMarca(cautare);
                model_lista.removeAllElements();
                int j=0;
                for(Employee i:lista)
                {
                    String temp=i.getPrenume()+" "+i.getNume()+" "+i.getMarca();
                    model_lista.add(j,temp);
                    j++;
                }
            }
        };
        ActionListener modificareBD=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prenume=text_prenume.getText();
                String nume=text_nume.getText();
                String marca=text_marca.getText();
                String cnp=text_CNP.getText();
                int salariu=Integer.parseInt(text_salariu.getText());
                String adresa=text_adresa.getText();
                String email=text_email.getText();
                String numar=text_telefon.getText();
                String loc=text_loc_nastere.getText();
                String dep=String.valueOf(optiuni_departament.getSelectedItem());
                String stare=String.valueOf(optiuni_stare_civila.getSelectedItem());
                String functie=String.valueOf(optiuni_functie.getSelectedItem());
                String nationalitate=String.valueOf(optiuni_nationalitate.getSelectedItem());

                    try {
                        Employee temporar=new Employee(prenume,nume,cnp,loc,stare,nationalitate,dep,salariu,marca,functie,numar,adresa,email);
                        DatabaseMethods.ModificareBD(temporar);
                        text_prenume.setText(prenume);
                        text_nume.setText(nume);
                        text_marca.setText(marca);
                        text_CNP.setText(cnp);
                        text_salariu.setText(String.valueOf(salariu));
                        text_adresa.setText(adresa);
                        text_email.setText(email);
                        text_telefon.setText(numar);
                        text_loc_nastere.setText(loc);
                        optiuni_departament.setSelectedItem(dep);
                        optiuni_stare_civila.setSelectedItem(stare);
                        optiuni_functie.setSelectedItem(functie);
                        optiuni_nationalitate.setSelectedItem(nationalitate);
                        model_lista.removeAllElements();
                        employeeList= DatabaseMethods.ListaBD();
                        int j=0;
                        for(Employee i:employeeList)
                        {
                            String temp=i.getPrenume()+" "+i.getNume()+" "+i.getMarca();
                            model_lista.add(j,temp);
                            j++;
                        }


                    }
                    catch (MyException x)
                    {
                        x.printStackTrace();
                    }
                }

            };

        MouseListener pasting=new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = lista_useri.locationToIndex(e.getPoint());
                    if (index >= 0) {
                        String selectedValue = lista_useri.getSelectedValue();
                        String[] temp = selectedValue.split(" ");
                        String marcax = temp[2];
                        Employee nou= DatabaseMethods.gasireBazatapeMarca(marcax);
                        text_prenume.setText(nou.getPrenume());
                        text_nume.setText(nou.getNume());
                        text_marca.setText(nou.getMarca());
                        text_CNP.setText(nou.getCNP());
                        text_salariu.setText(String.valueOf(nou.getSalariu()));
                        text_adresa.setText(nou.getAdresa());
                        text_email.setText(nou.getEmail());
                        text_telefon.setText(nou.getNumar_telefon());
                        text_loc_nastere.setText(nou.getLoc_nastere());
                        optiuni_departament.setSelectedItem(nou.getDepartament());
                        optiuni_stare_civila.setSelectedItem(nou.getStarea_civila());
                        optiuni_functie.setSelectedItem(nou.getFunctie());
                        optiuni_nationalitate.setSelectedItem(nou.getNationalitate());

                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };

        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean ascending = ascendingRadio.isSelected();
                List<Employee> sortedList = ListaBDSortByMarca(ascending);

                model_lista.removeAllElements();

                for (Employee employee : sortedList) {
                    String temp = employee.getPrenume() + " " + employee.getNume() + " " + employee.getMarca();
                    model_lista.addElement(temp);
                }
            }
        });

        stergere.addActionListener(stergere_bd);
        adaugare.addActionListener(adaugare_bd);
        refresh.addActionListener(reimprospatare);
        cautare.addActionListener(cautare_bd);
        lista_useri.addMouseListener(pasting);
        modificare.addActionListener(modificareBD);
    }

}
