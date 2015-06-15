(ns generator.core
  (:import org.pegdown.PegDownProcessor java.io.File)
  (:use hiccup.element hiccup.page)
  (:gen-class))

(def prcssr (PegDownProcessor.))

(defn md->html
  "Parses md"
  [md]
  (. prcssr markdownToHtml md))

(defn nav-item
  "Creates a navigation item"
  [name loc title]
  (link-to
   {:class "nav-item"  :id
    (if (.equalsIgnoreCase name title) "active" "passive")}
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
       [:title (str "Blockstorm - " name)]
       (include-css "./css/style.css")
       (include-css "http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic&subset=latin,latin-ext")
       (include-css "http://fonts.googleapis.com/css?family=Arvo:400,400italic,700italic")
       (include-css "http://fonts.googleapis.com/css?family=Cousine")
       (include-js "./js/jquery-1.7.2.min.js")
       (include-js "./js/script.js")
       (include-js "./js/analytics.js")]
      [:body
       [:div#header ; header
        [:div#headercontent
         (link-to {:id "blockstorm"} "./index.html" "Blockstorm")
         [:div#navigation
          (nav-item name "news.html" "News")
          (nav-item name "map.html" "Map")
          (nav-item name "donate.html" "Donate")
          (nav-item name "vote.html" "Vote")
          (nav-item name "rules.html" "Rules")
          (nav-item name "ban.html" "Ban")
          (nav-item name "wiki.html" "Wiki")]
         [:div#ip "play.blockstorm.com"]]]
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
