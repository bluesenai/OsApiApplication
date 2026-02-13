
package br.dev.blue.OsApiApplication.api.exceptionhandler;


public class ProblemaException {
   private Integer status;
   private LocaDateTime dataHora;
   private String titulo;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocaDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocaDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
   
}
