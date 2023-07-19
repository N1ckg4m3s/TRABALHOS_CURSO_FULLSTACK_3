package cadastropoo.model;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaRepo {
    private List<PessoaFisica> ListaPessoaFisica=new ArrayList();
    public void inserir(PessoaFisica pessoa){
        ListaPessoaFisica.add(pessoa);
    }
    public void alterar(PessoaFisica Antiga,PessoaFisica Nova){
        int i=ListaPessoaFisica.indexOf(Antiga);
        if(i != -1){
            ListaPessoaFisica.set(i,Nova);
        }
    }
    public void excluir(PessoaFisica pessoa){
        ListaPessoaFisica.remove(pessoa);
    }
    public PessoaFisica obter(int id){
        for (PessoaFisica pessoa : ListaPessoaFisica) {
            if (pessoa.GetId()==id) {
                return pessoa;
            }
        }
        return null;
    }
    public List<PessoaFisica> obterTodos(){
        return ListaPessoaFisica;
    }
    
    public void persistir(String NomeArquivo) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NomeArquivo))){
            oos.writeObject(ListaPessoaFisica);
        }
    }
    public void recuperar(String NomeArquivo) throws IOException, ClassNotFoundException {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NomeArquivo))){
            ListaPessoaFisica = (List<PessoaFisica>) ois.readObject();
        }
    }
}
