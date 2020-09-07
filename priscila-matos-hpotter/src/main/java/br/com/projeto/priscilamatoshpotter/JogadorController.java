package br.com.projeto.priscilamatoshpotter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/quadribol")
public class JogadorController {

    //LISTINHAS
    private List<Jogador> jogadores;

    //USADAS NOS MÉTODOS, POR ISSO NÃO INICIA COM O CONSTRUTOR

    private List<Jogador> jogLufa = new ArrayList<Jogador>();
    private List<Jogador> jogGrifinoria = new ArrayList<Jogador>();
    private List<Jogador> jogCornival = new ArrayList<Jogador>();
    private List<Jogador> jogSonserina = new ArrayList<Jogador>();


    //CONSTRUTOR
    //INICIA COM OS JOGADORES GATINHOS, excessão (Olivaras e Robson)
    // SE VOCÊ NÃO CONHECE O ROBSON, ALGO DE ERRADO NÃO ESTÁ CERTO

    public JogadorController() {
        jogadores = new ArrayList<Jogador>();

        //ADICIONANDO JOGADORES NAS LISTINHAS

        jogadores.add(new CasaLufaLufa("Cedrico", 15, "Artilheiro", "Lufa Lufa", 0));
        jogadores.add(new CasaLufaLufa("Newt", 15, "Artilheiro", "Lufa Lufa", 0));
        jogadores.add(new CasaGrifinoria("Harry Poter", 15, "Apanhador", "Grifinoria", 0));
        jogadores.add(new CasaGrifinoria("Rony", 15, "Apanhador", "Grifinoria", 0));
        jogadores.add(new CasaCornival("Olivaras", 16, "Goleiro", "Cornival", 0));
        jogadores.add(new CasaCornival("Robson", 16, "Goleiro", "Cornival", 0));
        jogadores.add(new CasaSonserina("Draco", 15, "Apanhador", "Sonserina", 0));
        jogadores.add(new CasaSonserina("Severo", 16, "Batedor", "Sonserina", 0));

    }

    //MOSTRANDO TODOS OS JOGADORES ADICIONADOS

    @GetMapping
    public ResponseEntity jogadores() {
        if (jogadores.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(jogadores);
    }

    //MOSTRANDO TODOS OS JOGADORES DE CADA CASA POR VEZ

    @GetMapping("/lufalufa")
    public ResponseEntity casaLufaLufa() {
        for (Jogador jogador : jogadores) {
            if (jogador instanceof CasaLufaLufa) {
                jogLufa.add(jogador);
            }
        }
        if (jogLufa.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(jogLufa);

    }

    @GetMapping("/grifinoria")
    public ResponseEntity casaGrifinoria() {
        for (Jogador jogador : jogadores) {
            if (jogador instanceof CasaGrifinoria) {
                jogGrifinoria.add(jogador);
            }
        }
        if (jogGrifinoria.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(jogGrifinoria);

    }

    @GetMapping("/cornival")
    public ResponseEntity casaCornival() {
        for (Jogador jogador : jogadores) {
            if (jogador instanceof CasaCornival) {
                jogCornival.add(jogador);
            }
        }
        if (jogCornival.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(jogCornival);

    }

    @GetMapping("/sonserina")
    public ResponseEntity casaSonserina() {
        for (Jogador jogador : jogadores) {
            if (jogador instanceof CasaSonserina) {
                jogSonserina.add(jogador);
            }
        }
        if (jogSonserina.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(jogSonserina);

    }

    //BUSCANDO UM JOGADOR DE CADA CASA ATRAVÉS DO ID

    @GetMapping("/lufalufa/{id}")
    public ResponseEntity lufaLufa(@PathVariable int id) {

        for (Jogador jogador : jogadores) {
            if (jogador instanceof CasaLufaLufa) {
                jogLufa.add(jogador);
            }
        }

        if (jogLufa.size() >= id) {
            return ResponseEntity.ok(jogLufa.get(id-1));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/grifinoria/{id}")
    public ResponseEntity grifinoria(@PathVariable int id) {

        for (Jogador jogador : jogadores) {
            if (jogador instanceof CasaGrifinoria) {
                jogGrifinoria.add(jogador);
            }
        }

        if (jogGrifinoria.size() >= id) {
            return ResponseEntity.ok(jogGrifinoria.get(id-1));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cornival/{id}")
    public ResponseEntity cornival(@PathVariable int id) {

        for (Jogador jogador : jogadores) {
            if (jogador instanceof CasaCornival) {
                jogCornival.add(jogador);
            }
        }

        if (jogCornival.size() >= id) {
            return ResponseEntity.ok(jogCornival.get(id-1));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/sonserina/{id}")
    public ResponseEntity sonserina(@PathVariable int id) {

        for (Jogador jogador : jogadores) {
            if (jogador instanceof CasaSonserina) {
                jogSonserina.add(jogador);
            }
        }

        if (jogSonserina.size() >= id) {
            return ResponseEntity.ok(jogSonserina.get(id-1));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //CADASTRAR JOGADORES
    // PODE TER O MESMO NOME PORQUE O ENDPOINT É DIFERENTE

    @PostMapping("/lufalufa")
    public ResponseEntity cadastrandoLufa (@RequestBody CasaLufaLufa novoLufa) {
        jogadores.add(novoLufa);
        return ResponseEntity.created(null).build();
    }

    @PostMapping("/grifinoria")
    public ResponseEntity cadastrandoGrifinoria (@RequestBody CasaGrifinoria novoGrifinoria) {
        jogadores.add(novoGrifinoria);
        return ResponseEntity.created(null).build();
    }

    @PostMapping("/cornival")
    public ResponseEntity cadastrandoCornival (@RequestBody CasaCornival novoCornival) {
        jogadores.add(novoCornival);
        return ResponseEntity.created(null).build();
    }

    @PostMapping("/sonserina")
    public ResponseEntity cadastrandoSonserina (@RequestBody CasaSonserina novoSonserina) {
        jogadores.add(novoSonserina);
        return ResponseEntity.created(null).build();
    }


    //EXPULSANDO OS JOGADORES RUINS, HAHAHAHA

    @DeleteMapping("/{id}")
    public ResponseEntity deletandoJogador(@PathVariable int id) {
        if (id > 0) {
            if (jogadores.size() >= id) {
                jogadores.remove(--id);

            }return ResponseEntity.ok().build();

        }return ResponseEntity.notFound().build();
    }

}
