(ns generator.core
  (:import org.pegdown.PegDownProcessor java.io.File)
  (:use hiccup.element hiccup.page)
  (:gen-class))

(def prcssr (PegDownProcessor.))

(defn md->html
  "Parses md"
  [md]
  (. prcssr markdownToHtml md))

(defn menu-item
  "Creates a menu item"
  [name loc title]
  (link-to
   {:class "menuitem"  :id
    (if (.equalsIgnoreCase name title) "active" "passive")}
   loc title))

(defn header-item
  "Creates a header item"
  [loc title]
  (link-to 
   {:class "headeritem"}
   loc title))

(defn generate-page
  "Generates a page"
  ([file]
     (generate-page
      (.replaceFirst (.getName file) "[.][^.]+$" "")
      (slurp (.getAbsolutePath file))))              
  ([name content]
     (html5
      [:head
       [:title "Blockstorm"]
       (include-css "./css/style.css")
       (include-css "./css/fonts.css")
       (include-js "./js/jquery-1.7.2.min.js")
       (include-js "./js/script.js")
       (include-js "./js/analytics.js")]
      [:body
       [:div#header ; header
        [:div#headeritems
         (header-item "/" "Home")
         (header-item
          "http://www.youtube.com/user/blockstormcom"
          "YouTube")
         (header-item
          "http://play.blockstorm.com:8123"
          "dynmap")
         (header-item
          "http://minecraft.nitrado.net/map/217.198.139.154/"
          "static map")
         (header-item
          "http://www.planetminecraft.com/server/playblockstormcom/"
          "planetminecraft")
         (header-item
          "https://minestatus.net/10335-blockstorm-com"
          "minestatus.net")
         (header-item
          "http://minecraftservers.org/server/119052"
          "minecraftservers.org")
         (header-item
          "http://minecraft-server-list.com/server/103935/"
          "minecraft-server-list.com")]]
       [:div#logo-and-menu
        [:div#logo-container ; logo
         [:div#logo "Blockstorm"]
         [:div#description
          "play.blockstorm.com - Minecraft Server since 2011"]]
        [:div#menu ; menu
         [:a#home {:href "index.html"}]
         (menu-item name "news.html" "News")
         (menu-item name "donate.html" "Donate")
         (menu-item name "vote.html" "Vote")
         (menu-item name "rules.html" "Rules")
         (menu-item name "shops.html" "Shops")
         ;;(menu-item name "market.html" "Market")
         (menu-item name "claim.html" "Claim")
         (menu-item name "ranks.html" "Ranks")
         (menu-item name "moderator.html" "Moderator")
         (menu-item name "ban.html" "Ban")
         (menu-item name "about.html" "About")]]
        (if (.equalsIgnoreCase name "index")
         [:div#slideshow ; slideshow
          (image {:id "current-image"}
                 "./img/slideshow08.png" "Slideshow")])
       [:div#content.shadow ; content
        [:div#content-container content]]])))

(defn generate-pages
  "Generates pages, returns list of names"
  []
  (map (fn [file]
         (let [name (.replaceFirst (.getName file) "[.][^.]+$" "")
               md (slurp (.getAbsolutePath file))]
           (spit (str "../" name ".html")
                 (generate-page name (md->html md)))
           name))
       (.listFiles (File. "../pages"))))

(defn generate
  "Generates websites for all files in pages/ dir"
  []
  (str "Generated " (count (generate-pages)) " files"))

(defn -main
  "I don't do a whole lot."
  [& args]
  (println "You should run this in a REPL"))
