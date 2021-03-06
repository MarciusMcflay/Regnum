/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle.Peca;

import Controle.Xadrez;
import Modelo.Campo;
import Modelo.Movimento;

/**
 *
 * @author marcius
 */
public class Testudo extends Peca{
    public Testudo() {
        this.fatorVida = 1;
        this.vidaTotal = 4;
    }
    
    @Override
    public boolean pintaCampo(int pecaPega, Campo campoSelecionado, boolean selecionarCampo){        
        int vida = (campoSelecionado.peca1() == Xadrez.TESTUDO)? campoSelecionado.vidaPeca1(): campoSelecionado.vidaPeca2();
        int caminhou = 0;
        
        //Caminhando para o centro pela Direita
        for(int i=0; i<vida && (campoSelecionado.getFaceAcimaDireita().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAcimaDireita().peca2() == Xadrez.TESTUDO); i++){
            campoSelecionado = campoSelecionado.getFaceAcimaDireita();
            // O caminho para baixo é para Esquerda
            caminhou = 1;
        }
        
        //Caminhando para o centro pela Esquerda
        if(caminhou == 0){
            for(int i=0; i<vida && (campoSelecionado.getFaceAcimaEsquerda().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAcimaEsquerda().peca2() == Xadrez.TESTUDO); i++){
                campoSelecionado = campoSelecionado.getFaceAcimaEsquerda();
                // O caminho para baixo é para Direita
                caminhou = 2;
            }
        }
        if(caminhou == 0){// O campo selecionado é a peca mais procimo ao centro
            if(campoSelecionado.getFaceAbaixoDireita() != null && (campoSelecionado.getFaceAbaixoDireita().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAbaixoDireita().peca2() == Xadrez.TESTUDO)){
                // O caminho para baixo é para Direita
                caminhou = 2;
            }else if(campoSelecionado.getFaceAbaixoEsquerda() != null && (campoSelecionado.getFaceAbaixoEsquerda().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAbaixoEsquerda().peca2() == Xadrez.TESTUDO)){
                // O caminho para baixo é para Esquerda
                caminhou = 1;
            // O caminho cruzou pelo lado esquerdo do triangulo
            }else if(campoSelecionado.getColuna()== 0 && (campoSelecionado.getFaceAcimaEsquerda().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAcimaEsquerda().peca2() == Xadrez.TESTUDO)){
                // O caminho para baixo é para Esquerda
                caminhou = 1;
            // O caminho cruzou pelo lado direito do triangulo    
            }else if(campoSelecionado.getColuna() == campoSelecionado.getLinha() && (campoSelecionado.getFaceAcimaDireita().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAcimaDireita().peca2() == Xadrez.TESTUDO)){
                // O caminho para baixo é para Direita
                caminhou = 2;
            }
        };
        
        boolean move = false;
        
        for(int i=0; i<vida; i++){
            if(selecionarCampo){
                if(campoSelecionado.getFaceAbaixoDireita() != null)     if(campoSelecionado.getFaceAbaixoDireita().campoVazio()){   campoSelecionado.getFaceAbaixoDireita().setFundoVerde(); move=true;}    else if(campoSelecionado.campoInimigo(Movimento.PEGARP1, campoSelecionado.getFaceAbaixoDireita()) &&    ((campoSelecionado.getFaceAbaixoDireita().vidaPeca1()/Xadrez.getTratadores()[Xadrez.REI-1].fatorVida)==1)){     campoSelecionado.getFaceAbaixoDireita().setFundoVermelho(); move=true;}     else if(campoSelecionado.campoAmigo(Movimento.PEGARP1, campoSelecionado.getFaceAbaixoDireita())     && Rei.amigo(campoSelecionado.getFaceAbaixoDireita())){    campoSelecionado.getFaceAbaixoDireita().setFundoAzul();move=true;}
                if(campoSelecionado.getFaceAbaixoEsquerda()!= null)     if(campoSelecionado.getFaceAbaixoEsquerda().campoVazio()){  campoSelecionado.getFaceAbaixoEsquerda().setFundoVerde(); move=true;}   else if(campoSelecionado.campoInimigo(Movimento.PEGARP1, campoSelecionado.getFaceAbaixoEsquerda()) &&   ((campoSelecionado.getFaceAbaixoEsquerda().vidaPeca1()/Xadrez.getTratadores()[Xadrez.REI-1].fatorVida)==1)){    campoSelecionado.getFaceAbaixoEsquerda().setFundoVermelho(); move=true;}    else if(campoSelecionado.campoAmigo(Movimento.PEGARP1, campoSelecionado.getFaceAbaixoEsquerda())    && Rei.amigo(campoSelecionado.getFaceAbaixoEsquerda())){   campoSelecionado.getFaceAbaixoEsquerda().setFundoAzul();move=true;}
                if(campoSelecionado.getFaceAcimaDireita() != null)      if(campoSelecionado.getFaceAcimaDireita().campoVazio()){    campoSelecionado.getFaceAcimaDireita().setFundoVerde(); move=true;}     else if(campoSelecionado.campoInimigo(Movimento.PEGARP1, campoSelecionado.getFaceAcimaDireita()) &&     ((campoSelecionado.getFaceAcimaDireita().vidaPeca1()/Xadrez.getTratadores()[Xadrez.REI-1].fatorVida)==1)){      campoSelecionado.getFaceAcimaDireita().setFundoVermelho(); move=true;}      else if(campoSelecionado.campoAmigo(Movimento.PEGARP1, campoSelecionado.getFaceAcimaDireita())      && Rei.amigo(campoSelecionado.getFaceAcimaDireita())){     campoSelecionado.getFaceAcimaDireita().setFundoAzul();move=true;}
                if(campoSelecionado.getFaceAcimaEsquerda() != null)     if(campoSelecionado.getFaceAcimaEsquerda().campoVazio()){   campoSelecionado.getFaceAcimaEsquerda().setFundoVerde(); move=true;}    else if(campoSelecionado.campoInimigo(Movimento.PEGARP1, campoSelecionado.getFaceAcimaEsquerda()) &&    ((campoSelecionado.getFaceAcimaEsquerda().vidaPeca1()/Xadrez.getTratadores()[Xadrez.REI-1].fatorVida)==1)){     campoSelecionado.getFaceAcimaEsquerda().setFundoVermelho(); move=true;}     else if(campoSelecionado.campoAmigo(Movimento.PEGARP1, campoSelecionado.getFaceAcimaEsquerda())     && Rei.amigo(campoSelecionado.getFaceAcimaEsquerda())){    campoSelecionado.getFaceAcimaEsquerda().setFundoAzul();move=true;}
                if(campoSelecionado.getQuinaAbaixo() != null)           if(campoSelecionado.getQuinaAbaixo().campoVazio()){         campoSelecionado.getQuinaAbaixo().setFundoVerde(); move=true;}          else if(campoSelecionado.campoInimigo(Movimento.PEGARP1, campoSelecionado.getQuinaAbaixo()) &&          ((campoSelecionado.getQuinaAbaixo().vidaPeca1()/Xadrez.getTratadores()[Xadrez.REI-1].fatorVida)==1)){           campoSelecionado.getQuinaAbaixo().setFundoVermelho(); move=true;}           else if(campoSelecionado.campoAmigo(Movimento.PEGARP1, campoSelecionado.getQuinaAbaixo())           && Rei.amigo(campoSelecionado.getQuinaAbaixo())){          campoSelecionado.getQuinaAbaixo().setFundoAzul();move=true;}
                if(campoSelecionado.getQuinaEsquerda() != null)         if(campoSelecionado.getQuinaEsquerda().campoVazio()){       campoSelecionado.getQuinaEsquerda().setFundoVerde(); move=true;}        else if(campoSelecionado.campoInimigo(Movimento.PEGARP1, campoSelecionado.getQuinaEsquerda()) &&        ((campoSelecionado.getQuinaEsquerda().vidaPeca1()/Xadrez.getTratadores()[Xadrez.REI-1].fatorVida)==1)){         campoSelecionado.getQuinaEsquerda().setFundoVermelho(); move=true;}         else if(campoSelecionado.campoAmigo(Movimento.PEGARP1, campoSelecionado.getQuinaEsquerda())         && Rei.amigo(campoSelecionado.getQuinaEsquerda())){        campoSelecionado.getQuinaEsquerda().setFundoAzul();move=true;}
                if(campoSelecionado.getQuinaDireita() != null)          if(campoSelecionado.getQuinaDireita().campoVazio()){        campoSelecionado.getQuinaDireita().setFundoVerde(); move=true;}         else if(campoSelecionado.campoInimigo(Movimento.PEGARP1, campoSelecionado.getQuinaDireita()) &&         ((campoSelecionado.getQuinaDireita().vidaPeca1()/Xadrez.getTratadores()[Xadrez.REI-1].fatorVida)==1)){          campoSelecionado.getQuinaDireita().setFundoVermelho(); move=true;}          else if(campoSelecionado.campoAmigo(Movimento.PEGARP1, campoSelecionado.getQuinaDireita())          && Rei.amigo(campoSelecionado.getQuinaDireita())){         campoSelecionado.getQuinaDireita().setFundoAzul();move=true;}
                if(campoSelecionado.getQuinaAcima() != null)            if(campoSelecionado.getQuinaAcima().campoVazio()){          campoSelecionado.getQuinaAcima().setFundoVerde(); move=true;}           else if(campoSelecionado.campoInimigo(Movimento.PEGARP1, campoSelecionado.getQuinaAcima()) &&           ((campoSelecionado.getQuinaAcima().vidaPeca1()/Xadrez.getTratadores()[Xadrez.REI-1].fatorVida)==1)){            campoSelecionado.getQuinaAcima().setFundoVermelho(); move=true;}            else if(campoSelecionado.campoAmigo(Movimento.PEGARP1, campoSelecionado.getQuinaAcima())            && Rei.amigo(campoSelecionado.getQuinaAcima())){           campoSelecionado.getQuinaAcima().setFundoAzul();move=true;}
            }else{
                if(campoSelecionado.getFaceAbaixoDireita() != null)     if(campoSelecionado.getFaceAbaixoDireita().campoVazio()){   campoSelecionado.getFaceAbaixoDireita().setFundo(); move=true;}         else if(campoSelecionado.campoInimigo(Movimento.PEGARP1, campoSelecionado.getFaceAbaixoDireita()) &&    ((campoSelecionado.getFaceAbaixoDireita().vidaPeca1()/Xadrez.getTratadores()[Xadrez.REI-1].fatorVida)==1)){     campoSelecionado.getFaceAbaixoDireita().setFundo(); move=true;}             else if(campoSelecionado.campoAmigo(Movimento.PEGARP1, campoSelecionado.getFaceAbaixoDireita())     && Rei.amigo(campoSelecionado.getFaceAbaixoDireita())){    campoSelecionado.getFaceAbaixoDireita().setFundo();move=true;}
                if(campoSelecionado.getFaceAbaixoEsquerda()!= null)     if(campoSelecionado.getFaceAbaixoEsquerda().campoVazio()){  campoSelecionado.getFaceAbaixoEsquerda().setFundo(); move=true;}        else if(campoSelecionado.campoInimigo(Movimento.PEGARP1, campoSelecionado.getFaceAbaixoEsquerda()) &&   ((campoSelecionado.getFaceAbaixoEsquerda().vidaPeca1()/Xadrez.getTratadores()[Xadrez.REI-1].fatorVida)==1)){    campoSelecionado.getFaceAbaixoEsquerda().setFundo(); move=true;}            else if(campoSelecionado.campoAmigo(Movimento.PEGARP1, campoSelecionado.getFaceAbaixoEsquerda())    && Rei.amigo(campoSelecionado.getFaceAbaixoEsquerda())){   campoSelecionado.getFaceAbaixoEsquerda().setFundo();move=true;}
                if(campoSelecionado.getFaceAcimaDireita() != null)      if(campoSelecionado.getFaceAcimaDireita().campoVazio()){    campoSelecionado.getFaceAcimaDireita().setFundo(); move=true;}          else if(campoSelecionado.campoInimigo(Movimento.PEGARP1, campoSelecionado.getFaceAcimaDireita()) &&     ((campoSelecionado.getFaceAcimaDireita().vidaPeca1()/Xadrez.getTratadores()[Xadrez.REI-1].fatorVida)==1)){      campoSelecionado.getFaceAcimaDireita().setFundo(); move=true;}              else if(campoSelecionado.campoAmigo(Movimento.PEGARP1, campoSelecionado.getFaceAcimaDireita())      && Rei.amigo(campoSelecionado.getFaceAcimaDireita())){     campoSelecionado.getFaceAcimaDireita().setFundo();move=true;}
                if(campoSelecionado.getFaceAcimaEsquerda() != null)     if(campoSelecionado.getFaceAcimaEsquerda().campoVazio()){   campoSelecionado.getFaceAcimaEsquerda().setFundo(); move=true;}         else if(campoSelecionado.campoInimigo(Movimento.PEGARP1, campoSelecionado.getFaceAcimaEsquerda()) &&    ((campoSelecionado.getFaceAcimaEsquerda().vidaPeca1()/Xadrez.getTratadores()[Xadrez.REI-1].fatorVida)==1)){     campoSelecionado.getFaceAcimaEsquerda().setFundo(); move=true;}             else if(campoSelecionado.campoAmigo(Movimento.PEGARP1, campoSelecionado.getFaceAcimaEsquerda())     && Rei.amigo(campoSelecionado.getFaceAcimaEsquerda())){    campoSelecionado.getFaceAcimaEsquerda().setFundo();move=true;}
                if(campoSelecionado.getQuinaAbaixo() != null)           if(campoSelecionado.getQuinaAbaixo().campoVazio()){         campoSelecionado.getQuinaAbaixo().setFundo(); move=true;}               else if(campoSelecionado.campoInimigo(Movimento.PEGARP1, campoSelecionado.getQuinaAbaixo()) &&          ((campoSelecionado.getQuinaAbaixo().vidaPeca1()/Xadrez.getTratadores()[Xadrez.REI-1].fatorVida)==1)){           campoSelecionado.getQuinaAbaixo().setFundo(); move=true;}                   else if(campoSelecionado.campoAmigo(Movimento.PEGARP1, campoSelecionado.getQuinaAbaixo())           && Rei.amigo(campoSelecionado.getQuinaAbaixo())){          campoSelecionado.getQuinaAbaixo().setFundo();move=true;}
                if(campoSelecionado.getQuinaEsquerda() != null)         if(campoSelecionado.getQuinaEsquerda().campoVazio()){       campoSelecionado.getQuinaEsquerda().setFundo(); move=true;}             else if(campoSelecionado.campoInimigo(Movimento.PEGARP1, campoSelecionado.getQuinaEsquerda()) &&        ((campoSelecionado.getQuinaEsquerda().vidaPeca1()/Xadrez.getTratadores()[Xadrez.REI-1].fatorVida)==1)){         campoSelecionado.getQuinaEsquerda().setFundo(); move=true;}                 else if(campoSelecionado.campoAmigo(Movimento.PEGARP1, campoSelecionado.getQuinaEsquerda())         && Rei.amigo(campoSelecionado.getQuinaEsquerda())){        campoSelecionado.getQuinaEsquerda().setFundo();move=true;}
                if(campoSelecionado.getQuinaDireita() != null)          if(campoSelecionado.getQuinaDireita().campoVazio()){        campoSelecionado.getQuinaDireita().setFundo(); move=true;}              else if(campoSelecionado.campoInimigo(Movimento.PEGARP1, campoSelecionado.getQuinaDireita()) &&         ((campoSelecionado.getQuinaDireita().vidaPeca1()/Xadrez.getTratadores()[Xadrez.REI-1].fatorVida)==1)){          campoSelecionado.getQuinaDireita().setFundo(); move=true;}                  else if(campoSelecionado.campoAmigo(Movimento.PEGARP1, campoSelecionado.getQuinaDireita())          && Rei.amigo(campoSelecionado.getQuinaDireita())){         campoSelecionado.getQuinaDireita().setFundo();move=true;}
                if(campoSelecionado.getQuinaAcima() != null)            if(campoSelecionado.getQuinaAcima().campoVazio()){          campoSelecionado.getQuinaAcima().setFundo(); move=true;}                else if(campoSelecionado.campoInimigo(Movimento.PEGARP1, campoSelecionado.getQuinaAcima()) &&           ((campoSelecionado.getQuinaAcima().vidaPeca1()/Xadrez.getTratadores()[Xadrez.REI-1].fatorVida)==1)){            campoSelecionado.getQuinaAcima().setFundo(); move=true;}                    else if(campoSelecionado.campoAmigo(Movimento.PEGARP1, campoSelecionado.getQuinaAcima())            && Rei.amigo(campoSelecionado.getQuinaAcima())){           campoSelecionado.getQuinaAcima().setFundo();move=true;}
            }
            
            if(caminhou == 0){
                break;
            } else if(caminhou == 1){ // Indo para esquerda
                if(campoSelecionado.getFaceAbaixoEsquerda() != null && (campoSelecionado.getFaceAbaixoEsquerda().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAbaixoEsquerda().peca2() == Xadrez.TESTUDO)){
                    campoSelecionado = campoSelecionado.getFaceAbaixoEsquerda();
                }else if(campoSelecionado.getColuna()== 0 && (campoSelecionado.getFaceAcimaEsquerda().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAcimaEsquerda().peca2() == Xadrez.TESTUDO)){
                    campoSelecionado = campoSelecionado.getFaceAcimaEsquerda();
                }
            }else{
                if(campoSelecionado.getFaceAbaixoDireita()!= null && (campoSelecionado.getFaceAbaixoDireita().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAbaixoDireita().peca2() == Xadrez.TESTUDO)){
                        campoSelecionado = campoSelecionado.getFaceAbaixoDireita();
                    }else if(campoSelecionado.getColuna() == campoSelecionado.getLinha() && (campoSelecionado.getFaceAcimaDireita().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAcimaDireita().peca2() == Xadrez.TESTUDO)){
                        campoSelecionado = campoSelecionado.getFaceAcimaDireita();
                    }
            }
        }
        
        
        return move;
    }

    @Override
    public boolean amigo(int pecaTipo, int[] parametros) {
        return false;
    }

    @Override
    public boolean amigo(int pecaPega, Campo campo) {
        return false;
    }
 
    public static void abrirTestudos(Campo campoSelecionado, Campo campoDestino){
        Campo[] movimentos = new Campo[4];
        movimentos[0] = campoSelecionado;
        movimentos[1] = campoSelecionado;
        movimentos[2] = campoSelecionado;
        movimentos[3] = campoSelecionado;
        
        boolean[] abrir = new boolean[4];
        for(int j=0; j<4; j++){
            abrir[j] = true;
        }
        
        int vida = campoSelecionado.vidaPeca1();
            
        for(int i=0; i<vida-1; i++){
            if(abrir[0]) try{ movimentos[0] = movimentos[0].getFaceAbaixoDireita(); }catch(Exception e){}
            if(abrir[1]) try{ movimentos[1] = movimentos[1].getFaceAbaixoEsquerda(); }catch(Exception e){}
            if(abrir[2]) try{ movimentos[2] = movimentos[2].getFaceAcimaDireita(); }catch(Exception e){}            
            if(abrir[3]) try{ movimentos[3] = movimentos[3].getFaceAcimaEsquerda(); }catch(Exception e){}
            for(int j=0; j<4; j++){
                if(abrir[j] && movimentos[j] != null){
                    abrir[j] = movimentos[j].campoVazio();   
                }else{
                    abrir[j] = false;
                }
            }
        }
        for(int j=0; j<4; j++){
            if(abrir[j]){
                if(movimentos[j] == campoDestino){
                    int jogador = campoSelecionado.jogador1();
                    campoSelecionado.addPeca1(Xadrez.TESTUDO, Xadrez.getTratadores()[Xadrez.TESTUDO-1].getVidaTotal());
                    for(int i=0; i<vida-1; i++){
                        switch(j){
                            case 0: try{ campoSelecionado = campoSelecionado.getFaceAbaixoDireita(); }catch(Exception e){}
                                break;
                            case 1: try{ campoSelecionado = campoSelecionado.getFaceAbaixoEsquerda(); }catch(Exception e){}
                                break;
                            case 2: try{ campoSelecionado = campoSelecionado.getFaceAcimaDireita(); }catch(Exception e){}
                                break;
                            case 3: try{ campoSelecionado = campoSelecionado.getFaceAcimaEsquerda(); }catch(Exception e){}
                                break;
                        }
                        campoSelecionado.addJogador1(jogador);
                        campoSelecionado.addPeca1(Xadrez.TESTUDO, vida);
                    }
                    return;
                }
            }
        }
    }
    
    public static int apagarTestudos(Campo campoSelecionado) {
        int vida = (campoSelecionado.peca1() == Xadrez.TESTUDO)? campoSelecionado.vidaPeca1(): campoSelecionado.vidaPeca2();
        int caminhou = 0;
        
        //Caminhando para o centro pela Direita
        for(int i=0; i<vida && (campoSelecionado.getFaceAcimaDireita().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAcimaDireita().peca2() == Xadrez.TESTUDO); i++){
            campoSelecionado = campoSelecionado.getFaceAcimaDireita();
            // O caminho para baixo é para Esquerda
            caminhou = 1;
        }
        
        //Caminhando para o centro pela Esquerda
        if(caminhou == 0){
            for(int i=0; i<vida && (campoSelecionado.getFaceAcimaEsquerda().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAcimaEsquerda().peca2() == Xadrez.TESTUDO); i++){
                campoSelecionado = campoSelecionado.getFaceAcimaEsquerda();
                // O caminho para baixo é para Direita
                caminhou = 2;
            }
        }
        if(caminhou == 0){// O campo selecionado é a peca mais procimo ao centro
            if(campoSelecionado.getFaceAbaixoDireita() != null && (campoSelecionado.getFaceAbaixoDireita().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAbaixoDireita().peca2() == Xadrez.TESTUDO)){
                // O caminho para baixo é para Direita
                caminhou = 2;
            }else if(campoSelecionado.getFaceAbaixoEsquerda() != null && (campoSelecionado.getFaceAbaixoEsquerda().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAbaixoEsquerda().peca2() == Xadrez.TESTUDO)){
                // O caminho para baixo é para Esquerda
                caminhou = 1;
            // O caminho cruzou pelo lado esquerdo do triangulo
            }else if(campoSelecionado.getColuna()== 0 && (campoSelecionado.getFaceAcimaEsquerda().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAcimaEsquerda().peca2() == Xadrez.TESTUDO)){
                // O caminho para baixo é para Esquerda
                caminhou = 1;
            // O caminho cruzou pelo lado direito do triangulo    
            }else if(campoSelecionado.getColuna() == campoSelecionado.getLinha() && (campoSelecionado.getFaceAcimaDireita().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAcimaDireita().peca2() == Xadrez.TESTUDO)){
                // O caminho para baixo é para Direita
                caminhou = 2;
            }
        }
        if(caminhou == 0){ // Só existe um Testudo
            if(campoSelecionado.peca1() == Xadrez.TESTUDO){
                campoSelecionado.matarPeca1();
            }else{
                campoSelecionado.matarPeca2();
            }
        }else{
            if(caminhou == 1){ // Indo para esquerda
                for(int i=0; i<vida; i++){
                    if(campoSelecionado.peca1() == Xadrez.TESTUDO){
                        campoSelecionado.matarPeca1();
                    }else{
                        campoSelecionado.matarPeca2();
                    }
                    if(campoSelecionado.getFaceAbaixoEsquerda() != null && (campoSelecionado.getFaceAbaixoEsquerda().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAbaixoEsquerda().peca2() == Xadrez.TESTUDO)){
                        campoSelecionado = campoSelecionado.getFaceAbaixoEsquerda();
                    }else if(campoSelecionado.getColuna()== 0 && (campoSelecionado.getFaceAcimaEsquerda().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAcimaEsquerda().peca2() == Xadrez.TESTUDO)){
                        campoSelecionado = campoSelecionado.getFaceAcimaEsquerda();
                    }
                }
            }else{
                for(int i=0; i<vida; i++){
                    if(campoSelecionado.peca1() == Xadrez.TESTUDO){
                        campoSelecionado.matarPeca1();
                    }else{
                        campoSelecionado.matarPeca2();
                    }
                    if(campoSelecionado.getFaceAbaixoDireita()!= null && (campoSelecionado.getFaceAbaixoDireita().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAbaixoDireita().peca2() == Xadrez.TESTUDO)){
                        campoSelecionado = campoSelecionado.getFaceAbaixoDireita();
                    }else if(campoSelecionado.getColuna() == campoSelecionado.getLinha() && (campoSelecionado.getFaceAcimaDireita().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAcimaDireita().peca2() == Xadrez.TESTUDO)){
                        campoSelecionado = campoSelecionado.getFaceAcimaDireita();
                    }
                }
            }
        }
        
        return vida;
    }
    
    static void diminuirVida(Campo campoSelecionado, int dano) {
        if(campoSelecionado.peca2() != Xadrez.TESTUDO){
            System.err.println("Veio diminuir a vida de um testudo mas veio dar algo errado!!!");
        }
        int vida = campoSelecionado.vidaPeca2();
        int caminhou = 0;
        
        //Caminhando para o centro pela Direita
        for(int i=0; i<vida && (campoSelecionado.getFaceAcimaDireita().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAcimaDireita().peca2() == Xadrez.TESTUDO); i++){
            campoSelecionado = campoSelecionado.getFaceAcimaDireita();
            // O caminho para baixo é para Esquerda
            caminhou = 1;
        }
        
        //Caminhando para o centro pela Esquerda
        if(caminhou == 0){
            for(int i=0; i<vida && (campoSelecionado.getFaceAcimaEsquerda().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAcimaEsquerda().peca2() == Xadrez.TESTUDO); i++){
                campoSelecionado = campoSelecionado.getFaceAcimaEsquerda();
                // O caminho para baixo é para Direita
                caminhou = 2;
            }
        }
        if(caminhou == 0){// O campo selecionado é a peca mais procimo ao centro
            if(campoSelecionado.getFaceAbaixoDireita() != null && (campoSelecionado.getFaceAbaixoDireita().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAbaixoDireita().peca2() == Xadrez.TESTUDO)){
                // O caminho para baixo é para Direita
                caminhou = 2;
            }else if(campoSelecionado.getFaceAbaixoEsquerda() != null && (campoSelecionado.getFaceAbaixoEsquerda().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAbaixoEsquerda().peca2() == Xadrez.TESTUDO)){
                // O caminho para baixo é para Esquerda
                caminhou = 1;
            // O caminho cruzou pelo lado esquerdo do triangulo
            }else if(campoSelecionado.getColuna()== 0 && (campoSelecionado.getFaceAcimaEsquerda().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAcimaEsquerda().peca2() == Xadrez.TESTUDO)){
                // O caminho para baixo é para Esquerda
                caminhou = 1;
            // O caminho cruzou pelo lado direito do triangulo    
            }else if(campoSelecionado.getColuna() == campoSelecionado.getLinha() && (campoSelecionado.getFaceAcimaDireita().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAcimaDireita().peca2() == Xadrez.TESTUDO)){
                // O caminho para baixo é para Direita
                caminhou = 2;
            }
        }
        if(caminhou == 0){ // Só existe um Testudo
            if(campoSelecionado.peca1() == Xadrez.TESTUDO){
                campoSelecionado.matarPeca1();
            }else{
                campoSelecionado.matarPeca2();
            }
        }else{
            if(caminhou == 1){ // Indo para esquerda
                for(int i=0; i<vida; i++){
                    if(campoSelecionado.peca1() == Xadrez.TESTUDO){
                        if(dano > i){
                            campoSelecionado.matarPeca1();
                        }else{
                            campoSelecionado.peca1Vida((-1)*dano);
                        }
                    }else{
                        if(dano > i){
                            campoSelecionado.matarPeca2();
                        }else{
                            campoSelecionado.peca2Vida((-1)*dano);
                        }
                    }
                    if(campoSelecionado.getFaceAbaixoEsquerda() != null && (campoSelecionado.getFaceAbaixoEsquerda().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAbaixoEsquerda().peca2() == Xadrez.TESTUDO)){
                        campoSelecionado = campoSelecionado.getFaceAbaixoEsquerda();
                    }else if(campoSelecionado.getColuna()== 0 && (campoSelecionado.getFaceAcimaEsquerda().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAcimaEsquerda().peca2() == Xadrez.TESTUDO)){
                        campoSelecionado = campoSelecionado.getFaceAcimaEsquerda();
                    }
                }
            }else{
                for(int i=0; i<vida; i++){
                    if(campoSelecionado.peca1() == Xadrez.TESTUDO){
                        if(dano > i){
                            campoSelecionado.matarPeca1();
                        }else{
                            campoSelecionado.peca1Vida((-1)*dano);
                        }
                    }else{
                        if(dano > i){
                            campoSelecionado.matarPeca2();
                        }else{
                            campoSelecionado.peca2Vida((-1)*dano);
                        }
                    }
                    if(campoSelecionado.getFaceAbaixoDireita()!= null && (campoSelecionado.getFaceAbaixoDireita().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAbaixoDireita().peca2() == Xadrez.TESTUDO)){
                        campoSelecionado = campoSelecionado.getFaceAbaixoDireita();
                    }else if(campoSelecionado.getColuna() == campoSelecionado.getLinha() && (campoSelecionado.getFaceAcimaDireita().peca1() == Xadrez.TESTUDO || campoSelecionado.getFaceAcimaDireita().peca2() == Xadrez.TESTUDO)){
                        campoSelecionado = campoSelecionado.getFaceAcimaDireita();
                    }
                }
            }
        }
    }
}

