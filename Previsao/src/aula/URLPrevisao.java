package aula;

import xml.Cidade;
import xml.Cidades;
import xml.Previsao;
import xml.Previsoes;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class URLPrevisao {

    public String getXMLPrevisao(String cidade) throws Exception {
        String charset = java.nio.charset.StandardCharsets.UTF_8.name();
        String linha, resultado = "";
        String urlListaCidade = "http://servicos.cptec.inpe.br/XML/cidade/7dias/"+ cidade +"/previsao.xml";
        /* codifica os parâmetros */
        String parametro = String.format(urlListaCidade, URLEncoder.encode(cidade, charset));
        URL url = new URL(parametro);
        URLConnection conexao = url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        while ((linha = reader.readLine()) != null) {
            resultado += linha;
        }
        return resultado;
    }

    public Previsao[] xmlToObjectPrevisao(String xml) throws Exception {
        StringReader sr = new StringReader(xml);
        /* a base do XML é uma marcação de nome cidades */
        JAXBContext context = JAXBContext.newInstance(Previsoes.class);
        Unmarshaller un = context.createUnmarshaller();
        Previsoes previsoes = (Previsoes) un.unmarshal(sr);
        return previsoes.getPrevisao();
    }

}