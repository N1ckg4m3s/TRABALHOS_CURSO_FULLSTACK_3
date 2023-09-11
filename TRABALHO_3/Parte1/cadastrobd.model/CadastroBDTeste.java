package cadastrobd.model;

import java.util.List;

public class CadastroBDTeste {
    public static void main(String[] args) {
        System.out.println("Start Testes");
        //Instanciar uma pessoa física e persistir no banco de dados.
        PessoaFisica PesF=new PessoaFisica(1,"nome","logradouro","cidade","estado","11912345678","Email@Email.com","123.456.789-00");
        PessoaFisicaDAO PesFDao=new PessoaFisicaDAO();
        PesFDao.incluir(PesF);
        
        //Alterar os dados da pessoa física no banco.
        PesF.Setnome("Pessoa Fisica, Nome Alterado");
        PesFDao.alterar(PesF);
        
        //Consultar todas as pessoas físicas do banco de dados e listar no console
        List<PessoaFisica> TodasPesF = PesFDao.getPessoas();
        for (PessoaFisica pf : TodasPesF) {
            pf.Exibir();
        }
        //Excluir a pessoa física criada anteriormente no banco.
        PesFDao.excluir(PesF);
        
        //Instanciar uma pessoa jurídica e persistir no banco de dados.
        PessoaJuridica PesJ=new PessoaJuridica(1,"nome","logradouro","cidade","estado","11912345678","Email@Email.com","123.456.789-00");
        PessoaJuridicaDAO PesJDao=new PessoaJuridicaDAO();
        PesJDao.incluir(PesJ);
        
        //Alterar os dados da pessoa jurídica no banco.
        PesJ.Setnome("Pessoa Juridica, Nome Alterado");
        PesJDao.alterar(PesJ);
        
        
        //Consultar todas as pessoas jurídicas do banco e listar no console.
        List<PessoaJuridica> TodasPesJ = PesJDao.getPessoas();
        for (PessoaJuridica pj : TodasPesJ) {
            pj.Exibir();
        }
        
        //Excluir a pessoa jurídica criada anteriormente no banco.
        PesJDao.excluir(PesJ);
        
    }
}
