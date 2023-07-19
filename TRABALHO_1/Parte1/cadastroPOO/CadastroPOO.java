import cadastropoo.model.PessoaFisica;
import cadastropoo.model.PessoaFisicaRepo;
import cadastropoo.model.PessoaJuridica;
import cadastropoo.model.PessoaJuridicaRepo;
import java.io.IOException;

public class CadastroPOO {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        repo1.inserir(new PessoaFisica(1,"Ana","11111111111",25));
        repo1.inserir(new PessoaFisica(2,"Carlos","22222222222",52));
        repo1.persistir("pessoasFisicas.dat");
        System.out.println("Pessoas Fisicas Armazenados:");
        
        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        repo2.recuperar("pessoasFisicas.dat");
        System.out.println("Pessoas Fisicas recuperados:");
        for (PessoaFisica Pes:repo2.obterTodos()){
            Pes.Exibir();
        }
        
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        repo3.inserir(new PessoaJuridica(1,"XPTO Sales","33333333333333"));
        repo3.inserir(new PessoaJuridica(2,"XPTO Solution","44444444444444"));
        repo3.persistir("pessoasJuridicas.dat");
        System.out.println("Pessoas Juridicas Armazenados:");
        
        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        repo4.recuperar("pessoasJuridicas.dat");
        System.out.println("Pessoas Juridicas recuperados:");
         for (PessoaJuridica Pes:repo4.obterTodos()){
            Pes.Exibir();
        }
    }
}
