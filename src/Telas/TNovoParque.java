package src.Telas;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import src.Brinquedo;
import src.Parque;
import src.Restaurante;
import src.Files.FPark;
import src.Interface.Estilo;
import src.Interface.JGerente;
import src.Interface.Tela;

// Tela para adição de novo parque
public class TNovoParque extends Tela implements ActionListener {

    private JPanel novoParque; // Novo painel para adicionar os componentes referentes ao parque

    private JLabel parque; // Título

    private JLabel nome;
    private JTextField campo_nome ;

    private JLabel descricao;
    private JTextField campo_descricao;

    private JLabel preco;
    private JTextField campo_preco;

    private JButton criar; // Criar novo parque -> ir para a tela Comeco
    private JButton cancelar; // Cancelar -> voltar para a tela Inicio
    
    public TNovoParque( int width, int height ){
        super( width, height);
        this.start();
    }

    public TNovoParque( int width, int height, JGerente jGerente ){
        super( width, height, jGerente );
        this.start();
    }

    public JPanel getNovoParque(){
        return this.novoParque;
    }

    public void start(){
        JLabel title = new JLabel( "GERENCIADOR" );
        title.setFont( Estilo.robotoTitle );
        title.setForeground( Estilo.branco );

        this.headerLayout = new SpringLayout();

        this.header.setLayout( this.headerLayout );
        this.header.add(title);

        // Definição do posicionamento do título com base no painel "header" < this.header >
        this.headerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, title, 0, SpringLayout.VERTICAL_CENTER, this.header);
        this.headerLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this.header);

        // Painel referente ao "card" de cadastro de um novo parque
        this.novoParque = new JPanel();

        SpringLayout layout = new SpringLayout();

        this.novoParque.setLayout(layout);

        this.novoParque.setPreferredSize( new Dimension( 550, 500 ) );
        this.novoParque.setBackground( Estilo.vermelhinho );

        this.body.add(this.novoParque, 1);

        // Centralizando o "card" de novo parque na tela
        this.bodyLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.novoParque, 0, SpringLayout.VERTICAL_CENTER, this.body);
        this.bodyLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.novoParque, 0, SpringLayout.HORIZONTAL_CENTER, this.body);

        // Título do card
        this.parque = new JLabel( "Novo parque" );

        this.nome = new JLabel( "Nome" );
        this.campo_nome = new JTextField();

        this.descricao = new JLabel( "Descrição" );
        this.campo_descricao = new JTextField();

        this.preco = new JLabel( "Preço" );
        this.campo_preco = new JTextField();

        this.criar = new JButton( "Criar" );
        this.cancelar = new JButton( "Cancelar" );

        // Configurando estilos de fonte, cor de texto
        parque.setFont( Estilo.robotoTitle );
        parque.setForeground( Estilo.branco );

        nome.setFont( Estilo.robotoLabel );
        nome.setForeground( Estilo.branco );

        descricao.setFont( Estilo.robotoLabel );
        descricao.setForeground( Estilo.branco );

        preco.setFont( Estilo.robotoLabel );
        preco.setForeground( Estilo.branco );

        criar.setFont( Estilo.robotoLabel );
        criar.setForeground( Estilo.vermelhinho );

        cancelar.setFont( Estilo.robotoLabel );
        cancelar.setForeground( Estilo.vermelhinho );

        criar.setBorderPainted(false);
        cancelar.setBorderPainted(false);

        criar.setBackground( Estilo.branco );
        cancelar.setBackground( Estilo.branco );

        // Configurando tamanhos
        Dimension dim = new Dimension( 144, 27 );

        criar.setPreferredSize(dim);
        cancelar.setPreferredSize(dim);

        dim = new Dimension( 400, 27 );

        campo_nome.setPreferredSize(dim);
        campo_descricao.setPreferredSize(dim);
        campo_preco.setPreferredSize(dim);

        // Configurando estilo dos campos de texto
        campo_nome.setFont( Estilo.robotoText );
        campo_nome.setBackground( Estilo.branco );
        campo_nome.setForeground( Estilo.preto );

        campo_descricao.setFont( Estilo.robotoText );
        campo_descricao.setBackground( Estilo.branco );
        campo_descricao.setForeground( Estilo.preto );

        campo_preco.setFont( Estilo.robotoText );
        campo_preco.setBackground( Estilo.branco );
        campo_preco.setForeground( Estilo.preto );

        // Adicionando componentes do painel principal desta tela
        this.novoParque.add(parque);

        this.novoParque.add(nome);
        this.novoParque.add(campo_nome);

        this.novoParque.add(descricao);
        this.novoParque.add(campo_descricao);

        this.novoParque.add(preco);
        this.novoParque.add(campo_preco);

        this.novoParque.add(criar);
        this.novoParque.add(cancelar);

        this.criar.addActionListener( this );
        this.cancelar.addActionListener( this );

        // Posicionando os componentes dentro do painel de criação de novo parque

        // Título
        layout.putConstraint( SpringLayout.HORIZONTAL_CENTER, parque, 0, SpringLayout.HORIZONTAL_CENTER, this.novoParque );
        layout.putConstraint( SpringLayout.NORTH, parque, 16, SpringLayout.NORTH, this.novoParque );

        // Nome        
        layout.putConstraint( SpringLayout.WEST, nome, 75, SpringLayout.WEST, this.novoParque );
        layout.putConstraint( SpringLayout.NORTH, nome, 32, SpringLayout.SOUTH, parque );

        layout.putConstraint( SpringLayout.WEST, campo_nome, 0, SpringLayout.WEST, nome );
        layout.putConstraint( SpringLayout.NORTH, campo_nome, 4, SpringLayout.SOUTH, nome );

        //Descrição
        layout.putConstraint( SpringLayout.WEST, descricao, 0, SpringLayout.WEST, campo_nome );
        layout.putConstraint( SpringLayout.NORTH, descricao, 32, SpringLayout.SOUTH, campo_nome );

        layout.putConstraint( SpringLayout.WEST, campo_descricao, 0, SpringLayout.WEST, descricao );
        layout.putConstraint( SpringLayout.NORTH, campo_descricao, 4, SpringLayout.SOUTH, descricao );

        //Preço
        layout.putConstraint( SpringLayout.WEST, preco, 0, SpringLayout.WEST, campo_descricao );
        layout.putConstraint( SpringLayout.NORTH, preco, 32, SpringLayout.SOUTH, campo_descricao );

        layout.putConstraint( SpringLayout.WEST, campo_preco, 0, SpringLayout.WEST, preco );
        layout.putConstraint( SpringLayout.NORTH, campo_preco, 4, SpringLayout.SOUTH, preco );

        //Criar
        layout.putConstraint( SpringLayout.WEST, criar, 0, SpringLayout.WEST, campo_preco );
        layout.putConstraint( SpringLayout.NORTH, criar, 48, SpringLayout.SOUTH, campo_preco );

        //Cancelar
        layout.putConstraint( SpringLayout.EAST, cancelar, 0, SpringLayout.EAST, campo_preco );
        layout.putConstraint( SpringLayout.NORTH, cancelar, 48, SpringLayout.SOUTH, campo_preco );
    }

    @Override
    public void actionPerformed(ActionEvent event){
        if ( event.getSource() == this.criar ){
            System.out.println( "Novo parque criado!" );

            String nome = this.campo_nome.getText();
            String desc = this.campo_descricao.getText();
            String preco = this.campo_preco.getText();

            System.out.println("Nome: " + nome);
            System.out.println("Descrição: " + desc);
            System.out.println("Preço: " + preco);
            System.out.println();

            Parque parque = new Parque( nome, desc, Float.parseFloat(preco), 100);

            Brinquedo brinks1 = new Brinquedo("dino", "sfd", 5, 100, 8, 0, 18, 30 );
            brinks1.setAbertura( 7, 0);
            brinks1.setFechamento( 17, 0);
            parque.addAtracao( brinks1 );

            Brinquedo brinks2 = new Brinquedo("montaria", "kkk", 4, 100, 8, 0, 18, 30 );
            brinks2.setAbertura( 6, 0);
            brinks2.setFechamento( 22, 0);
            parque.addAtracao( brinks2 );

            Restaurante rest1 = new Restaurante("Sorveteria", "Tem sorvete", 3, 40 );
            rest1.setAbertura( 8, 0);
            rest1.setFechamento( 18, 0);
            parque.addAtracao( rest1 );

            Restaurante rest2 = new Restaurante("Cabanhas", "Tem cabanhas", 2, 40 );
            rest2.setAbertura( 9, 0);
            rest2.setFechamento( 16, 0);
            parque.addAtracao( rest2 );

            Brinquedo brinks3 = new Brinquedo("manga", "Ai zé da manga", 1, 100, 8, 0, 18, 30 );
            brinks3.setAbertura( 7, 0);
            brinks3.setFechamento( 17, 0);
            parque.addAtracao( brinks3 );

            Brinquedo brinks4 = new Brinquedo("cavalo", "ratinhoo", 0, 100, 8, 0, 18, 30 );
            brinks4.setAbertura( 6, 0);
            brinks4.setFechamento( 22, 0);
            parque.addAtracao( brinks4 );

            Restaurante rest3 = new Restaurante("Lanchinho do zé", "Tem lanche :D", 7, 40 );
            rest3.setAbertura( 8, 0);
            rest3.setFechamento( 18, 0);
            parque.addAtracao( rest3 );

            Restaurante rest4 = new Restaurante("Tua mãe", "Aquela baleia", 6, 40 );
            rest4.setAbertura( 9, 0);
            rest4.setFechamento( 16, 0);
            parque.addAtracao( rest4 );

            Restaurante rest5 = new Restaurante("Teu pai", "Aquele feio", 8, 40 );
            rest5.setAbertura( 9, 0);
            rest5.setFechamento( 16, 0);
            parque.addAtracao( rest5 );

            Restaurante rest6 = new Restaurante("Ilalari", "Larialala", 9, 40 );
            rest6.setAbertura( 9, 0);
            rest6.setFechamento( 16, 0);
            parque.addAtracao( rest6 );

            if ( this.jan instanceof JGerente ){
                ( (JGerente) this.jan ).setParque( parque );
                if ( !parque.getAtracoes().isEmpty() ){
                    ( (JGerente) this.jan ).setAtracoes( parque.getAtracoes() );
                    ( (JGerente) this.jan ).setIDAtrac( 0 );
                }
            }

            FPark.escrever( parque );

            this.jan.trocarTela( "Começo" );
        }

        if ( event.getSource() == this.cancelar ){
            System.out.println( "Criação do parque cancelada!" );
            this.jan.trocarTela( "inicio" );
        }
    }
}
