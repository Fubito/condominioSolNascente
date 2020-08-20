package br.univali.condominio.java;

import java.sql.*;
import java.util.ArrayList;

public class CondominioConnector {
    private static final String url = "jdbc:mysql://localhost:3306/condominio?useTimezone=true&serverTimezone=America/Sao_Paulo";
    private static final String user = "root";
    private static final String password = "2511199904022001";


    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e){
            throw  new RuntimeException("Erro na conexão com o banco de dados" +
                    e);
        }
    }
    public static void closeConnection(Connection conn){
        try{
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao fechar a conexão com o banco de dados: " +
                    e);
        }
    }

    public static String space(String word, int number){
        return new String (new char[(number - word.length())]).replace("\0", " ");
    }

    //Achados E Perdidos
    public static void insertAchadosEPerdidos(String itemAchado, int idFuncionario){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO achadoseperdidos" +
                    "(itemAchado, Id_Funcionario)" +
                    " VALUES ('"+itemAchado+"', '"+idFuncionario+"')");
            insert.executeUpdate();
        }catch (SQLException e){
            e.getErrorCode();
        }
    }
    public static ArrayList<String> getAchadosEPerdidosId(){
        ArrayList<String> array = new ArrayList<>();
        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT Id_AchadosEPerdidos FROM achadoseperdidos");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                array.add(result.getString("Id_AchadosEPerdidos"));
            }
            return array;
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao achar os dados Achados e Perdidos: " +
                    e);
        }
    }
    public static ArrayList<String> getAchadosEPerdidosItem(){
        ArrayList<String> array = new ArrayList<>();
        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT itemAchado FROM achadoseperdidos");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                array.add(result.getString("itemAchado"));
            }
            return array;
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao achar os dados Achados e Perdidos: " +
                    e);
        }
    }
    public static ArrayList<Integer> getAchadosEPerdidosFuncionarioId(){
        ArrayList<Integer> array = new ArrayList<>();
        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT Id_Funcionario FROM achadoseperdidos");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                array.add(Integer.parseInt(result.getString("Id_Funcionario")));
            }
            return array;
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao achar os dados Achados e Perdidos: " +
                    e);
        }
    }
    public static void updateAchadosEPerdidos(int id, String itemAchado, int idFuncionario ){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("UPDATE achadoseperdidos SET " +
                    "itemAchado = '"+itemAchado+"', Id_Funcionario = '"+idFuncionario+"'" +
                    "WHERE Id_AchadosEPerdidos = '"+id+"'"
                    );
            insert.executeUpdate();
        }catch (SQLException e){
            e.getErrorCode();
        }
    }
    public static void deleteAchadosEPerdidos(int id){

        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("DELETE FROM achadoseperdidos " +
                    "WHERE Id_AchadosEPerdidos = '"+id+"'");
            statement.executeUpdate();
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao achar os dados Achados e Perdidos: " +
                    e);
        }
    }

    //Funcionarios
    public static void insertFuncionarioTelefone(String nome, String telefone, int idCargo){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO funcionarios" +
                    "(nome, telefone, Id_Cargo)" +
                    " VALUES ('"+nome+"','"+telefone+"', '"+idCargo+"')");
            insert.executeUpdate();
        }catch (SQLException e){
            e.getErrorCode();
        }
    }
    public static void insertFuncionario(String nome, int idCargo){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO funcionarios" +
                    "(nome, Id_Cargo)" +
                    " VALUES ('"+nome+"','"+idCargo+"')");
            insert.executeUpdate();
        }catch (SQLException e){
            e.getErrorCode();
        }
    }
    public static ArrayList<String> getFuncionarioId(){
        ArrayList<String> array = new ArrayList<>();
        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT Id_Funcionario FROM funcionarios");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                array.add(result.getString("Id_Funcionario"));
            }
            return array;
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao achar os Id's dos funcionarios: " +
                    e);
        }
    }
    public static ArrayList<String> getNomeFuncionario(){
        ArrayList<String> array = new ArrayList<>();
        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT Nome FROM funcionarios");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                array.add(result.getString("Nome"));
            }
            return array;
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao achar os nomes dos funcionarios: " +
                    e);
        }
    }
    public static ArrayList<Integer> getFuncionarioCargoId(){
        ArrayList<Integer> array = new ArrayList<>();
        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT Id_Cargo FROM funcionarios");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                array.add(Integer.parseInt(result.getString("Id_Cargo")));
            }
            return array;
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao achar os Id's dos Cargos dos funcionarios: " +
                    e);
        }
    }
    public static ArrayList<String> getTelefoneFuncionario(){
        ArrayList<String> array = new ArrayList<>();
        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT Telefone FROM funcionarios");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                array.add(result.getString("Telefone"));
            }
            return array;
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao achar os telefones dos funcionarios: " +
                    e);
        }
    }
    public static void updateFuncionario(int id, String nome, int idCargo, String telefone ){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("UPDATE funcionarios SET " +
                    "Nome = '"+nome+"',Telefone = '"+telefone+"', Id_Cargo = '"+idCargo+"'" +
                    "WHERE Id_Funcionario = '"+id+"'"
            );
            insert.executeUpdate();
        }catch (SQLException e){
            e.getErrorCode();
        }
    }
    public static void deleteFuncionario(int id){

        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("DELETE FROM funcionarios " +
                    "WHERE Id_Funcionario = '"+id+"'");
            statement.executeUpdate();
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao deletar o funcionario: " +
                    e);
        }
    }

    //Condomino
    public static void insertCondomino(String nome, String ap){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO condomino" +
                    "(Nome, Ap)" +
                    " VALUES ('"+nome+"', '"+ap+"')");
            insert.executeUpdate();
        }catch (SQLException e){
            e.getErrorCode();
        }
    }
    public static void insertCondominoTelefone(String nome, String telefone, String ap){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO condomino" +
                    "(Nome, Ap, Telefone)" +
                    " VALUES ('"+nome+"', '"+ap+"','"+telefone+"')");
            insert.executeUpdate();
        }catch (SQLException e){
            e.getErrorCode();
        }
    }
    public static ArrayList<String> getCondominoId(){
        ArrayList<String> array = new ArrayList<>();
        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT Id_Condomino FROM condomino");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                array.add(result.getString("Id_Condomino"));
            }
            return array;
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao achar os Id's dos condominos: " +
                    e);
        }
    }
    public static ArrayList<String> getNomeCondomino(){
        ArrayList<String> array = new ArrayList<>();
        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT Nome FROM condomino");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                array.add(result.getString("Nome"));
            }
            return array;
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao achar os nomes dos condominos: " +
                    e);
        }
    }
    public static ArrayList<Integer> getCondominoAp(){
        ArrayList<Integer> array = new ArrayList<>();
        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT Ap FROM condomino");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                array.add(Integer.parseInt(result.getString("Ap")));
            }
            return array;
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao achar os Ap's dos condominos: " +
                    e);
        }
    }
    public static ArrayList<String> getTelefoneCondomino(){
        ArrayList<String> array = new ArrayList<>();
        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT Telefone FROM condomino");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                array.add(result.getString("Telefone"));
            }
            return array;
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao achar os telefones dos condominos: " +
                    e);
        }
    }
    public static void updateCondomino(int id, String nome, String ap, String telefone ){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("UPDATE condomino SET " +
                    "Nome = '"+nome+"',Telefone = '"+telefone+"', Ap = '"+ap+"'" +
                    "WHERE Id_Condomino = '"+id+"'"
            );
            insert.executeUpdate();
        }catch (SQLException e){
            e.getErrorCode();
        }
    }
    public static void deleteCondomino(int id){

        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("DELETE FROM condomino " +
                    "WHERE Id_Condomino = '"+id+"'");
            statement.executeUpdate();
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao deletar o condomino: " +
                    e);
        }
    }

    //Cargos
    public static void insertCargo(String nomeDoCargo){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO cargos" +
                    "(NomeDoCargo)" +
                    " VALUES ('"+nomeDoCargo+"')");
            insert.executeUpdate();
        }catch (SQLException e){
            e.getErrorCode();
        }
    }
    public static ArrayList<String> getCargoId(){
        ArrayList<String> array = new ArrayList<>();
        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT Id_Cargo FROM cargos");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                array.add(result.getString("Id_Cargo"));
            }
            return array;
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao achar os Id's dos cargos: " +
                    e);
        }
    }
    public static ArrayList<String> getNomeCargo(){
        ArrayList<String> array = new ArrayList<>();
        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT NomeDoCargo FROM cargos");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                array.add(result.getString("NomeDoCargo"));
            }
            return array;
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao achar os nomes dos cargos: " +
                    e);
        }
    }
    public static void updateCargo(int id, String nomeDoCargo){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("UPDATE cargos SET " +
                    "NomeDoCargo = '"+nomeDoCargo+"'WHERE Id_Cargo = '"+id+"'"
            );
            insert.executeUpdate();
        }catch (SQLException e){
            e.getErrorCode();
        }
    }
    public static void deleteCargo(int id){

        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("DELETE FROM cargos " +
                    "WHERE Id_Cargo = '"+id+"'");
            statement.executeUpdate();
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao deletar os cargos: " +
                    e);
        }
    }

    //Reservas
    public static void insertReserva(String reserva, String dia, int idCondomino){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO reservas" +
                    "(Dia, Reserva, Id_Condomino)" +
                    " VALUES ('"+dia+"','"+reserva+"', '"+idCondomino+"')");
            insert.executeUpdate();
        }catch (SQLException e){
            e.getErrorCode();
        }
    }
    public static ArrayList<String> getReservaCondominoId(){
        ArrayList<String> array = new ArrayList<>();
        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT Id_Condomino FROM reservas");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                array.add(result.getString("Id_Condomino"));
            }
            return array;
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao achar os Id's das reservas: " +
                    e);
        }
    }
    public static ArrayList<String> getReserva(){
        ArrayList<String> array = new ArrayList<>();
        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT Reserva FROM reservas");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                array.add(result.getString("Reserva"));
            }
            return array;
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao achar as reservas da tabela reservas: " +
                    e);
        }
    }
    public static ArrayList<String> getDataReserva(){
        ArrayList<String> array = new ArrayList<>();
        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT Dia FROM reservas");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                array.add(result.getString("Dia"));
            }
            return array;
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao achar os dias da tabela reservas: " +
                    e);
        }
    }
    public static ArrayList<Integer> getReservaId(){
        ArrayList<Integer> array = new ArrayList<>();
        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT Id_Reserva FROM reservas");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                array.add(Integer.parseInt(result.getString("Id_Reserva")));
            }
            return array;
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao achar Id's da tavela reservas: " +
                    e);
        }
    }
    public static void updateReserva(int id, String dia, int idCondomino, String reserva ){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("UPDATE reservas SET " +
                    "Dia = '"+dia+"',Reserva = '"+reserva+"', Id_Condomino = '"+idCondomino+"'" +
                    "WHERE Id_Reserva = '"+id+"'"
            );
            insert.executeUpdate();
        }catch (SQLException e){
            e.getErrorCode();
        }
    }
    public static void deleteReserva(int id){

        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("DELETE FROM reservas " +
                    "WHERE Id_Reserva = '"+id+"'");
            statement.executeUpdate();
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao deletar uma reserva: " +
                    e);
        }
    }

    //ocorrencia
    public static void insertOcorrencia(String ocorrencia, String dia, int idCondomino){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO ocorrencias" +
                    "(Dia, Ocorrencia, Id_Condomino)" +
                    " VALUES ('"+dia+"','"+ocorrencia+"', '"+idCondomino+"')");
            insert.executeUpdate();
        }catch (SQLException e){
            e.getErrorCode();
        }
    }
    public static ArrayList<String> getOcorrenciaCondominoId(){
        ArrayList<String> array = new ArrayList<>();
        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT Id_Condomino FROM ocorrencias");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                array.add(result.getString("Id_Condomino"));
            }
            return array;
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao achar os Id's dos condominos da tabela ocorrencias: " +
                    e);
        }
    }
    public static ArrayList<String> getDataOcorrencia(){
        ArrayList<String> array = new ArrayList<>();
        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT Dia FROM ocorrencias");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                array.add(result.getString("Dia"));
            }
            return array;
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao achar os dias da tabela ocorrencias: " +
                    e);
        }
    }
    public static ArrayList<String> getOcorrencia(){
        ArrayList<String> array = new ArrayList<>();
        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT Ocorrencia FROM ocorrencias");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                array.add(result.getString("Ocorrencia"));
            }
            return array;
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao achar as Ocorrencias da tabela ocorrencias: " +
                    e);
        }
    }
    public static ArrayList<Integer> getOcorrenciaId(){
        ArrayList<Integer> array = new ArrayList<>();
        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT Id_Ocorrencia FROM ocorrencias");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                array.add(Integer.parseInt(result.getString("Id_Ocorrencia")));
            }
            return array;
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao achar os Id's das ocorrencias: " +
                    e);
        }
    }
    public static void updateOcorrencia(int id, String dia, int idCondomino, String ocorrencia ){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("UPDATE ocorrencias SET " +
                    "Dia = '"+dia+"',Ocorrencia = '"+ocorrencia+"', Id_Condomino = '"+idCondomino+"'" +
                    "WHERE Id_Ocorrencia = '"+id+"'"
            );
            insert.executeUpdate();
        }catch (SQLException e){
            e.getErrorCode();
        }
    }
    public static void deleteOcorrencia(int id){

        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("DELETE FROM ocorrencias " +
                    "WHERE Id_Ocorrencia = '"+id+"'");
            statement.executeUpdate();
        } catch (SQLException e){
            throw  new RuntimeException("Erro ao deletar as ocorrencias: " +
                    e);
        }
    }
}

