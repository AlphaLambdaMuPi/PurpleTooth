package com.pi.mu.lambda.alpha.purpletooth.connectedClientItem;

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
public class ConnectedClientContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<ConnectedClientItem> ITEMS = new ArrayList<ConnectedClientItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
//    public static Map<String, ConnectedClientItem> ITEM_MAP = new HashMap<String, ConnectedClientItem>();


    private static void addItem(ConnectedClientItem item) {
        ITEMS.add(item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class ConnectedClientItem {
        public String id;
        public String content;

        public ConnectedClientItem(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return id + " - " + content;
        }
    }
}
