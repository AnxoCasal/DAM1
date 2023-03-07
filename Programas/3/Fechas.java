import javax.naming.spi.DirStateFactory.Result;

public class Fechas {
    private int dia;
    private int mes;
    private int ano;

    public void setDia(int dia){
        if(dia>31||dia<1){
            this.dia = 1;
        } else {
            this.dia = dia;
        }
    }

    public void setMes(int mes){
        if(mes>12||mes<1){
            this.mes = 1;
        } else {
            this.mes = mes;
        }
    }
    
    public void setAno(int ano){
        this.ano = ano;
    }
    
    public int getDia(){
        return dia;
    }
    
    public int getMes(){
        return mes;
    }
    
    public int getAno(){
        return ano;
    }

    public Fechas(){
        this.dia = 28;
        this.mes = 12;
        this.ano = 2002;
    }

    public Fechas(int dia, int mes, int ano){
        dia = this.dia;
        mes = this.mes;
        ano = this.ano;
    }

    public String fechaFormateada(boolean formato){
        String result;
        if(formato){
            result = dia+"/"+mes+"/"+ano+"/";
            return result;
        } else {
            switch (mes) {
                case 1:
                    result = dia+"/Enero/"+ano+"/";
                    break;
            
                case 2:
                    result = dia+"/Febrero/"+ano+"/";
                    break;
            
                case 3:
                    result = dia+"/Marzo/"+ano+"/";
                    break;
            
                case 4:
                    result = dia+"/Abril/"+ano+"/";
                    break;
            
                case 5:
                    result = dia+"/Maio/"+ano+"/";
                    break;
            
                case 6:
                    result = dia+"/Junio/"+ano+"/";
                    break;
            
                case 7:
                    result = dia+"/Julio/"+ano+"/";
                    break;
            
                case 8:
                    result = dia+"/Agosto/"+ano+"/";
                    break;
            
                case 9:
                    result = dia+"/Septiembre/"+ano+"/";
                    break;
            
                case 10:
                    result = dia+"/Octubre/"+ano+"/";
                    break;
            
                case 11:
                    result = dia+"/Noviembre/"+ano+"/";
                    break;
            
                case 12:
                    result = dia+"/Diciembre/"+ano+"/";
                    break;
            
                default:
                    break;
            }
            return result;
        }
    }
}
