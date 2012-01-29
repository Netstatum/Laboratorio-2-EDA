#Crea una base de datos con medicamentos, compuestos y sintomas aleatorios

from random import choice, randint
from string import letters


def palabra():
    """
    Crea una palabra aleatorioa entre 3 y 20 caracteres
    """
    tamano=randint(3, 20)
    cadena=""
    while tamano>0:
        cadena+=choice(letters)
        tamano-=1
    return cadena

tamano=int(raw_input("Tamano de la base de datos> "))
f=open("database.txt", "w")

print "Creando base de datos de %i elementos..." %(tamano)
for x in range(tamano):
    f.write("nombre_medicamento = "+palabra()+"\n")
    f.write("nombre_compuesto = "+palabra()+"\n")
    c=""
    for y in range(randint(1, 5)):
        c+=palabra()+","
    f.write("sintomas = "+c+"\n\n")

print "Base de datos: database.txt creada"
