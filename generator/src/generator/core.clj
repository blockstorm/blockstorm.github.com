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
       [:title name]
       (include-css "./css/style.css")
       (include-js "./js/jquery-1.7.2.min.js")
       (include-js "./js/script.js")]
      [:body
       [:div#header.shadow ; header
        (link-to {:class "headeritem" :id "blockstorm"} "/" "blockstorm.com")
        (link-to {:class "headeritem"} "http://google.com/" "YouTube")
        (link-to {:class "headeritem"} "http://google.com/" "dynmap")
        (link-to {:class "headeritem"} "http://google.com/" "static map")
        (link-to {:class "headeritem"} "http://google.com/" "planetminecraft")
        (link-to {:class "headeritem"} "http://google.com/" "mcservers.org")
        (link-to {:class "headeritem"} "http://google.com/" "Minecraft Server List")]
       [:div#logo-container ; logo
        [:div#logo "blockstorm.com"]
        [:div#description "play.blockstorm.com - Minecraft Bukkit Server since 2011"]]
       [:div#menu.shadow.gradient ; menu
        (link-to {:class "menuitem" :id "home"} "/" "Home")
        (link-to {:class "menuitem"} "http://google.com/" "FAQ")
        (link-to {:class "menuitem"} "http://google.com/" "Donate")
        (link-to {:class "menuitem"} "http://google.com/" "Pictures")
        (link-to {:class "menuitem"} "http://google.com/" "Videos")]
       [:div#slideshow ; slideshow
        (image {:id "current-image"} "./img/slideshow01.png" "Slideshow")]
       [:div#content.shadow ; content
        [:div#content-container content]]])))

(defn generate
  "Generates websites for all files in posts/ dir"
  []
  (str "Generated "
       (count
        (map (fn [file]
               (let [name (.replaceFirst (.getName file) "[.][^.]+$" "")]
                 (spit (str "../" name ".html")
                       (generate-site name (md->html (slurp (.getAbsolutePath file)))))
                 name))
             (.listFiles (File. "../posts")))) " files"))

(defn -main
  "I don't do a whole lot."
  [& args]
  (println "You should run this in a REPL"))
