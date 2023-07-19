package cadastropoo.model;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaRepo {
    private List<PessoaJuridica> ListaPessoaJuridica=new ArrayList();
    public void inserir(PessoaJuridica pessoa){
        ListaPessoaJuridica.add(pessoa);
    }
    public void alterar(PessoaJuridica Antiga,PessoaJuridica Nova){
        int i=ListaPessoaJuridica.indexOf(Antiga);
        if(i != -1){
            ListaPessoaJuridica.set(i,Nova);
        }
    }
    public void excluir(PessoaJuridica pessoa){
        ListaPessoaJuridica.remove(pessoa);
    }
    public PessoaJuridica obter(String Cnpj){
        for (PessoaJuridica pessoa : ListaPessoaJuridica) {
            if (pessoa.GetCnpj().equals(Cnpj)) {
                return pessoa;
            }
        }
        return null;
    }
    public List<PessoaJuridica> obterTodos(){
        return ListaPessoaJuridica;
    }
    
    public void persistir(String NomeArquivo) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NomeArquivo))){
            oos.writeObject(ListaPessoaJuridica);
        }
    }
    public void recuperar(String NomeArquivo) throws IOException, ClassNotFoundException {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NomeArquivo))){
            ListaPessoaJuridica = (List<PessoaJuridica>) ois.readObject();
        }
    }
}
