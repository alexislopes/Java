package xml;

import javax.xml.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@XmlRootElement(name = "previsao")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"atualizacao", "dia", "tempo", "maxima", "minima", "iuv"})
public class Previsao {

    @XmlElement(name = "atualizacao")
    private Date atualizacao;
    @XmlElement(name = "dia")
    private Date dia;
    @XmlElement(name = "tempo")
    private String tempo;
    @XmlElement(name = "maxima")
    private Integer maxima;
    @XmlElement(name = "minima")
    private String minima;
    @XmlElement(name = "iuv")
    private String iuv;

    public Integer getMaxima() {
        return maxima;
    }

    public String getMinima() {
        return minima;
    }

    public String getIuv() {
        return iuv;
    }

    public Date getDia() {
        return dia;
    }

    public String getTempo() {
        return tempo;
    }

    public Date getAtualizacao() {
        return atualizacao;
    }



    @Override
    public String toString() {
        Locale locale = new Locale("pt", "BR");
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY - EEEE", locale);
        return
                "|   dia  | " + df.format(dia) + "\n" +
                "| tempo  | " + tempo + "\n" +
                "| máxima | " + maxima + "ºC\n" +
                "| mínima | " + minima  + "ºC\n" +
                "|  iuv   | " + iuv  + "\n";
    }
}
