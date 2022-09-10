package client;

import java.util.ArrayList;

public class IdCreator {

  private static ArrayList<Integer> usedIds = new ArrayList<Integer>();

  IdCreator() {}

  public static int createNewId() {
    int bufferId;
    bufferId = (int) (Math.random() * 9000) + 1000;

    if (usedIds.contains(bufferId)) return createNewId(); else {
      usedIds.add(bufferId);
      return bufferId;
    }
  }

  public static void removeId(int id) {
    for (int i = 0; i < usedIds.size(); i++) {
      if (id == usedIds.get(i)) usedIds.remove(i);
    }
  }

  public static boolean contains(int id) {
    return usedIds.contains(id);
  }
}
