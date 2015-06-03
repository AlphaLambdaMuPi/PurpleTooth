package com.pi.mu.lambda.alpha.purpletooth.clientItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class ClientContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<ClientItem> ITEMS = new ArrayList<ClientItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
//    public static Map<String, ClientItem> ITEM_MAP = new HashMap<String, ClientItem>();

    private static void addItem(ClientItem item) {
        ITEMS.add(item);
//        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class ClientItem {
        public String name;
        public String content;
        public String uuid;

        public ClientItem(String uuid, String name, String content) {
            this.name = name;
            this.content = content;
            this.uuid = uuid;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
