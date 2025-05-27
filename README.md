Git y Github  
**Primero**  
**crear y Entrar a una carpeta**  
mkdir "-" ==> Crear carpeta  
cd "-"  ==> entrar a la carpeta  
code . ==> abrir carpeta en vscode  
type nul > archivo.py ==> Crear un fichero.py

**estando dentro de la carpeta, utilizar el comando git (obligatorias)**  
git config --global user.name "-"  
git config --global user.email "-"

**Como hacer para inicializar git dentro de la carpeta?**  
git init

**Normalmente se crea la rama "Master", podemos cambiarle el nombre por main:**

&nbsp;git branch -m main

**Que es lo que esta pasando con mi carpeta?**

Git status

**Como agrego ficheros a mi git para el control de versioner?**

git add "-" ==> añadir un fichero

git add . ==> añadir todos los ficheros sin añadir

**como agregar un commit?**

git commit

**agregar un commit simple?**

git commit -m "-"

**GIT LOG**

- **como saber si la fotografia se ha realizado?**
    - git log **==>** hash, autor, fecha, commit
    - git log --graph **==>** lo vez con la rama graficada
    - git log --graph --pretty=oneline **==>** lo vez de manera mas simple, sin fecha
    - git log --graph --decorate --all --oneline **==>** Lo mismo pero sin el hash

**GIT CHECKOUT**

- **Volver al ultimo commit guardado de un fichero**
- git checkout "-"

**GIT RESET**

- **volver para atras en la ultima fotografia**
- git reset

**Como crear funciones para comandos?**

- git config --global alias.NOMBRE "CODIGO"
- Se invoca con git NOMBRE

**GIT IGNORE**

- **Quieres ignorar un fichero de tu paquete? Debes crear el fichero GitIgnore**
- type > .gitignore
- Detro de este fichero usar: **/NOMBREFICHERO
- Despues debes añadir el gitignore al commit

**GIT DIFF**

- **Como puedo saber que he cambiado de un fichero sin necesidad de hacer una fotografia?**
- git diff FICHERO O SOLO==> cambios dentro del fichero
- git diff RAMA ==> cambios dentro de una rama

**GIT RESET**

- **Como hago para volver a un commit y borrar los comit que estan delante de este? Cambia el head del log y borra los de delante**
- git reset --hard COMMIT
- puedes volver a poner el HEAD en el lugar donde estaba antes

**GIT REFLOG (HISTORIAL)**

- **Como puedo ver todos los cambias y comandos que hemos hechos con los commits?**
- git reflog

**GIT TAG (TITULOS)**

1.  **Como puedo agregar titulos a mi commit?**
    - git tag TEXTO (minusculas y pocos simbolos)
2.  Como puedo visualizar todos los tags que tengo?
    - git tag -l
3.  Como puedo ir a la version de un tag especificio?

- - git checkout tags/NOMBRE

**GIT SHOW**

- Mostrar detalles del commit etiquetado
- git show tag o hash

**BRANCH Y SWITHC (RAMAS)**

1.  1.  Crear rama

- - git branch NOMBRE
        
        ```
        - &nbsp;
            
            ```
            2. cambiar a esa rama
            - git switch NOMBRE
            
            ```
        ```
        
- **GIT MERGE**
    
    - **Para fusionar ramas**
    - estando dentro de una rama fusiono la otra rama
        - **git merge NOMBRe**
    - **Eliminar una rama**
        - **git branch -d RAMA**

**GIT STASH**

- **Funciona para crear copias locales momentanias, se guardan con un hash, pero no se incluyen dentro de un commit**
    - **git stash  ==> crea el stash y vuelves a tu ultimo commit**
    - **git stash list ==> visualizas tus stash creados**
    - **git stash pop ==> vuelves a ese stash creado**
    - **git stash drop ==> eliminas tu stash**

**REMOTEAR EL PROYECTO**

- **git remote add origin https://github.com/Jefferlol/HelloGit.git #url del repositorio**
- **git push -u origin main ==>  se utiliza para enviar los cambios locales al repositorio remoto**
- **git pull origin main  ==> se utiliza para actualizar tu copia local del repositorio con los cambios del repositorio remoto**
- **git fetch origin ==> se utiliza para descargar los cambios del repositorio remoto a tu repositorio local sin fusionarlos automáticamente**
