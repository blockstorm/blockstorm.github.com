(ns generator.core
  (:import org.pegdown.PegDownProcessor java.io.File)
  (:use hiccup.element hiccup.page)
  (:gen-class))

(def prcssr (PegDownProcessor.))

(defn md->html
  "Parses md"
  [md]
  (. prcssr markdownToHtml md))

(defn generate-site
  "Generates a website"
  ([file]
     (generate-site
      (.replaceFirst (.getName file) "[.][^.]+$" "")
      (slurp (.getAbsolutePath file))))              
  ([name content]
     (html5
      [:head
       [:title "blockstorm.com"]
       (include-css "./css/style.css")
       (include-js "./js/jquery-1.7.2.min.js")
       (include-js "./js/script.js")
       (include-js "./js/analytics.js")]
      [:body
       [:div#header.shadow ; header
        (link-to {:class "headeritem" :id "blockstorm"} "/" "home")
        (link-to {:class "headeritem"} "http://www.youtube.com/user/blockstormcom" "YouTube")
        (link-to {:class "headeritem"} "http://play.blockstorm.com:8123" "dynmap")
        (link-to {:class "headeritem"} "http://minecraft.nitrado.net/map/217.198.139.154/" "static map")
        (link-to {:class "headeritem"} "http://www.planetminecraft.com/server/playblockstormcom/" "planetminecraft")
        (link-to {:class "headeritem"} "https://minestatus.net/10335-blockstorm-com" "minestatus.net")
        (link-to {:class "headeritem"} "http://mcserverlist.net/servers/50a7b59a99b5e4001b000355" "mcserverlist.net")
        (link-to {:class "headeritem"} "http://mcservers.org/detail/play.blockstorm.com" "mcservers.org")
		(link-to {:class "headeritem"} "http://minecraft-server-list.com/server/103935/" "minecraft-server-list.com")]
       [:div#logo-container ; logo
        [:div#logo "blockstorm.com"]
        [:div#description "play.blockstorm.com - Minecraft Bukkit Server since 2011"]]
       [:div#menu.shadow.gradient ; menu
        [:a#home {:href "http://blockstorm.com/"}]
        (link-to {:class "menuitem"} "http://blockstorm.com/faq.html" "FAQ")
        (link-to {:class "menuitem"} "http://blockstorm.com/donate.html" "Donate")
        (link-to {:class "menuitem"} "http://blockstorm.com/vote.html" "Vote")
        (link-to {:class "menuitem"} "http://blockstorm.com/rules.html" "Rules")
		(link-to {:class "menuitem"} "http://blockstorm.com/market" "Market")
		(link-to {:class "menuitem"} "http://blockstorm.com/about" "About")
        [:div#ip "play.blockstorm.com"]]
       (if (.equalsIgnoreCase name "index")
         [:div#slideshow ; slideshow
          (image {:id "current-image"} "./img/slideshow01.png" "Slideshow")])
       [:div#content.shadow ; content
        [:div#content-container content]]])))

(defn generate
  "Generates websites for all files in pages/ dir"
  []
  (str "Generated "
       (count
        (map (fn [file]
               (let [name (.replaceFirst (.getName file) "[.][^.]+$" "")]
                 (spit (str "../" name ".html")
                       (generate-site name (md->html (slurp (.getAbsolutePath file)))))
                 name))
             (.listFiles (File. "../pages")))) " files"))

(defn -main
  "I don't do a whole lot."
  [& args]
  (println "You should run this in a REPL"))
