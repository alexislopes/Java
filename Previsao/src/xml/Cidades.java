package xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;

@XmlRootElement(name = "cidades")
@XmlType(propOrder = {"cidade"})
public class Cidades {
    @XmlElement
    private Cidade[] cidade;

    public Cidade[] getCidade() {
        return cidade;
    }

    @Override
    public String toString() {
        return "Cidades{" +
                "cidade=" + Arrays.toString(cidade) +
                '}';
    }
}