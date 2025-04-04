package clase2.src;

/*Defina una clase TempMinEstacion que encapsule la representación de las temperaturas
mínimas registradas en una estación meteorológica y brinde operaciones para:
• Retornar la mayor temperatura registrada
• Calcular el promedio de las temperaturas
• Contar cuántos días heló
• Decidir si hubo heladas
• Retornar la primera temperatura mayor a una dada; si no existe devolver el
mismo valor recibido.
• Decidir si las temperaturas registradas se produjeron en orden creciente*/
public class TempMinEstacion {
    private Float[] S;

    //Constructores
    public TempMinEstacion(Integer cant) {
        S = new Float[cant];
    }

    //Comandos

    public void establecerTempMin(Integer i, Float elem){
        S[i] = elem;
    }

    //Consultas

    public Float mayorTempMin(){
        Float mayor = S[0];
        for(int i=1;i<S.length;i++){
            if(S[i]>mayor){
                mayor = S[i];
            }
        }
        return mayor;
    }
    public Float promedioTempMin(){
        Float sumatoria = 0.0f;
        int i=0;
        while (i < S.length){
            sumatoria = sumatoria + S[i];
            i++;
        }
        return sumatoria/S.length;
    }
    public Integer cantHeladas(){
        Integer heladas = 0;
        for(int i=0; i<S.length;i++){
            if(S[i]<0){
                heladas++;
            }
        }
        return heladas;
    }
    public boolean huboHeladas(){
        Integer heladas = this.cantHeladas();
        if(heladas>0){
            return true;
        }
        return false;
    }
    public Float primeroMayor(Float t){
        Float mayor = t;
        int i=0;
        while(i < S.length){
            if(S[i]>t){
                mayor = S[i];
                i = S.length;
            }
            i++;
        }
        return mayor;
    }
    public boolean ordenadoCreciente(){
        boolean ordenado = true;
        int i=0;
        while(i < S.length-1 && ordenado){
            if(S[i]>S[i+1]){
                ordenado = false;
            }
            i++;
        }
        return ordenado;
    }

}
