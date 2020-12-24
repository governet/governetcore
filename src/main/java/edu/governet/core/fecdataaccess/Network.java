package edu.governet.core.fecdataaccess;

import java.util.*;

public class Network {
    public List<NetworkNode> nodes;
    public List<NetworkLink> links;

    public Network(List<NetworkNode> nodes, List<NetworkLink> links) {
        this.nodes = nodes;
        this.links = links;
    }

    public List<NetworkNode> getNodes() {
        return nodes;
    }

    public List<NetworkLink> getLinks() {
        return links;
    }

    public static class NetworkNode {
        String id;
        String name;
        String type;
        String party;

        public NetworkNode(String id, String name, String party, String type) {
            this.id = id;
            this.name = name;
            this.type = type;
            this.party = party;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public String getParty() {
            return party;
        }
    }

    public static class NetworkLink {
        String source;
        String target;

        public NetworkLink(String source, String target) {
            this.source = source;
            this.target = target;
        }

        public String getSource() {
            return source;
        }

        public String getTarget() {
            return target;
        }
    }
}
