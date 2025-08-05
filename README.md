# Proyecto Final - Canvas ULACIT  
### Requerimientos de Software | ULACIT

Este proyecto simula un sistema educativo inspirado en la plataforma Canvas, desarrollado como trabajo final del curso de **Requerimientos de Software** en la **ULACIT**. El sistema permite la gestión académica desde la perspectiva de estudiantes y profesores, incluyendo asignaciones, calificaciones, asistencia y más.

## 🎯 Objetivo

Implementar una solución de software funcional basada en los requerimientos levantados durante el curso, siguiendo las buenas prácticas de análisis y diseño.

## 🧩 Funcionalidades principales

- Gestión de cursos, grupos y materias.
- Control de asistencia.
- Registro y consulta de calificaciones.
- Visualización de asignaciones por curso.
- Interfaces diferenciadas para estudiante y profesor.

## 🛠️ Tecnologías utilizadas

- **Lenguaje:** Java
- **IDE sugerido:** NetBeans
- **Formato de persistencia:** Archivos `.dat` y `.txt`
- **Build system:** `build.xml` (Ant)

## 📂 Estructura del proyecto

Proyecto-Final_Canvas_IngRS/
│
├── src/
│ ├── CursoEstudiante/ # Interfaces y clases para vista del estudiante
│ ├── CursoProfesor/ # Funcionalidades y vistas para el profesor
│ └── BaseDatos/ # Manejo de persistencia y archivos
│
├── *.dat # Archivos de datos usados como base de datos
├── *.txt # Registros auxiliares (ej. asistencia.txt)
├── build.xml # Script para compilar el proyecto (Apache Ant)
├── manifest.mf # Manifest para empaquetado
└── .gitignore # Archivos excluidos del control de versiones


## ▶️ Cómo ejecutar

1. Clona este repositorio:
   ```bash
   git clone https://github.com/diartavia/Proyecto-Final_Canvas_IngRS.git

Abre el proyecto con NetBeans (recomendado) o cualquier IDE compatible con Java.

Ejecuta el archivo principal desde LogIn

📌 Notas
El proyecto no utiliza una base de datos relacional; toda la persistencia se maneja por archivos locales (.dat, .txt).

No se requiere configuración adicional, pero se recomienda ejecutarlo desde un entorno donde Java esté correctamente configurado.

👥 Autores
Diego Artavia
Jose Dias
Melanie Barrantes
Liam Paul
Fabricio Sanchez

🏫 Universidad
Proyecto desarrollado para el curso Requerimientos de Software
ULACIT - Universidad Latinoamericana de Ciencia y Tecnología
Profesor: Cristian Garcia
