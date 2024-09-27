class BrowserHistory {
    public class Node {
        String url;
        Node prev, next;

        public Node(String url){
            this.url=url;
            this.next=next;
            this.prev=prev;
        }
    }
    private Node current;

    public BrowserHistory(String homepage){
        current = new Node(homepage);
    }

    public void visit(String url) {
        Node newUrl = new Node(url);
        current.next = newUrl;
        newUrl.prev = current;
        current = newUrl;

    }

    public String back(int steps) {
        for (; current.prev !=null && steps > 0; steps--){
            current = current.prev;

        }
        return current.url;

    }

    public String forward(int steps) {
        for (; current.next !=null && steps > 0; steps--){
            current = current.next;

        }
        return current.url;

    }
    public static void main(String[] args) {
        // create BrowserHistory with homepage
        BrowserHistory browserHistory = new BrowserHistory("google.com");

        // visit some websites
        browserHistory.visit("facebook.com");
        browserHistory.visit("twitter.com");
        browserHistory.visit("youtube.com");

        // backward navigation
        System.out.println(browserHistory.back(1)); // should print "twitter.com"
        System.out.println(browserHistory.back(1)); // should print "facebook.com"

        // forward navigation
        System.out.println(browserHistory.forward(1)); // should print "twitter.com"

        // visiting a new site clears forward history
        browserHistory.visit("linkedin.com");
        System.out.println(browserHistory.back(2)); // should print "google.com"
        System.out.println(browserHistory.forward(2)); // should print "linkedin.com"
    }

}