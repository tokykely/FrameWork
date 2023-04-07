javac -d . /home/toky/Bureau/FrameWorkTest/FrameWork/UrlMap.java
javac -d . /home/toky/Bureau/FrameWorkTest/FrameWork/Mapping.java
javac -d . /home/toky/Bureau/FrameWorkTest/FrameWork/ModelView.java
javac -d . /home/toky/Bureau/FrameWorkTest/FrameWork/UrlInconue.java
javac -d . /home/toky/Bureau/FrameWorkTest/FrameWork/FrontServlet.java

cd /home/toky/Bureau/FrameWorkTest/FrameWork
jar cvf frameWork.jar * 
cp /home/toky/Bureau/FrameWorkTest/FrameWork/frameWork.jar /home/toky/Bureau/ProjetTest/WEB-INF/lib/
cd /home/toky/Bureau/ProjetTest/WEB-INF/classes/
javac -cp /home/toky/Bureau/ProjetTest/WEB-INF/lib/frameWork.jar -d . Chauffeur.java
javac -cp /home/toky/Bureau/ProjetTest/WEB-INF/lib/frameWork.jar -d . Fiara.java
cd /home/toky/Bureau/ProjetTest
jar cf Temporaire.war *
cp /home/toky/Bureau/ProjetTest/Temporaire.war /home/toky/logiciels/apache-tomcat-8.5.81/webapps
cd /home/toky/logiciels/apache-tomcat-8.5.81/bin/
./startup.sh
