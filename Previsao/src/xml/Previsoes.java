package xml;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;

@XmlRootElement(name = "cidade")
@XmlType(propOrder = {"previsao"})
public class Previsoes {
    @XmlElement
    private Previsao[] previsao;

    public Previsao[] getPrevisao(){
        return previsao;
    }

    @Override
    public String toString() {
        return "Previsoes{" +
                "previsao=" + Arrays.toString(previsao) +
                '}';
    }
}
