package AppServices;

import Classes.Item;
import Repositories.ItemRepository;
import java.io.IOException;
import java.util.ArrayList;

public class ItemAppService {

    public static void AddItem(Item i) throws IOException {
        ItemRepository repository = new ItemRepository();
        if (i.getId() != -1) {
            ArrayList<Item> itens = repository.GetAll();
            for (Item it : itens) {
                if (it.getId() == i.getId()) {
                    it.setNome(i.getNome());
                    it.setQuantidadeEstoque(i.getQuantidadeEstoque());
                    it.setValorAtual(i.getValorAtual());
                }
            }
            repository.SaveAll(itens);
        } else {
            repository.AddOne(i);
        }
        repository.Close();
    }

    public static void Delete(Item i) throws IOException {
        ItemRepository repository = new ItemRepository();
        Item remove = i;
        ArrayList<Item> itens = repository.GetAll();
        for (Item it : itens) {
            if (it.getId() == i.getId()) {
                remove = it;
            }
        }

        itens.remove(remove);
        repository.SaveAll(itens);

        repository.Close();
    }

    public static ArrayList<Item> GetGrid() throws IOException {
        ArrayList<Item> it = new ArrayList<Item>();
        ItemRepository repository = new ItemRepository();
        it = repository.GetAll();
        repository.Close();
        return it;
    }

    public static Item StringToItem(String s) throws IOException {
        ItemRepository repository = new ItemRepository();
        Item f = repository.StringToItem(s);
        return f;
    }

    public static Item StringToItemGrid(String linha) {
        String[] ls = linha.split("  |  ");
        long id = Long.parseLong(ls[0]);
        Item f = new Item(id, ls[2], Integer.parseInt(ls[4]), Double.parseDouble(ls[6]));
        return f;
    }
}
