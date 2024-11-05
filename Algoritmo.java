public class Algoritmo {
    private String nome;
    private String nomeBaseBusca;
    private String nomeBaseDaArvore;
    private double tempo;
    private int rotations;
    private int height;
    private String dataBase;


    public String getNomeBaseDaArvore() {
        return nomeBaseDaArvore;
    }

    public void setNomeBaseDaArvore(String nomeBaseDaArvore) {
        this.nomeBaseDaArvore = nomeBaseDaArvore;
    }

    public String getNomeBaseBusca() {
        return nomeBaseBusca;
    }

    public void setNomeBaseBusca(String nomeBaseBusca) {
        this.nomeBaseBusca = nomeBaseBusca;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getDataBase() {
        return dataBase;
    }

    public void setDataBase(String dataBase) {
        this.dataBase = dataBase;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public int getRotations() {
        return rotations;
    }

    public void setRotations(int rotations) {
        this.rotations = rotations;
    }

    public Algoritmo(String nome, double tempo, int rotations, int height, String dataBase) {
        this.nome = nome;
        this.tempo = tempo;
        this.rotations = rotations;
        this.height = height;
        this.dataBase = dataBase;
    }

    public Algoritmo(String nome, String nomeBaseDaArvore,String nomeBaseBusca, double tempo) {
        this.nome = nome;
        this.nomeBaseDaArvore = nomeBaseDaArvore;
        this.nomeBaseBusca = nomeBaseBusca;
        this.tempo = tempo;
    }
}