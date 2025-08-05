# Proyecto Final - Canvas Universitario (Ingeniería en RS)

Este proyecto simula una plataforma universitaria tipo Canvas desarrollada en Java. Permite a estudiantes y profesores interactuar en un entorno académico digitalizado, donde se pueden asignar calificaciones, gestionar asignaciones, tomar asistencias y visualizar el rendimiento por materia y grupo.

## 🎯 Objetivo

Desarrollar un sistema de gestión educativa que facilite:
- La administración de materias, profesores y estudiantes.
- La asignación y evaluación de tareas.
- El seguimiento de asistencia.
- La visualización de notas por curso y por estudiante.

## 🧩 Arquitectura del Proyecto

El sistema está dividido en paquetes según su rol:

src/
├── CursoEstudiante/ # Interfaces y clases para estudiantes
├── CursoProfesor/ # Interfaces y lógica para profesores
├── General/ # Clases base del sistema (Modelo y Controlador)
└── Pantallas/LogIn/ # Ventanas de inicio de sesión


## 📚 Clases Principales

- `Estudiante`, `Profesor`: Modelos base con credenciales y relaciones.
- `Materia`, `Grupo`, `Asignacion`: Entidades académicas.
- `Sistema`: Controlador estático del estado del sistema (usuario activo, listas globales).
- `NotaAsignacion`, `Asistencia`: Datos vinculados al rendimiento y la participación.

## ▶️ ¿Cómo ejecutar el proyecto?

Este proyecto fue desarrollado en NetBeans, pero puedes compilarlo desde consola o cualquier IDE compatible con Java.

### Requisitos
- Java JDK 8 o superior
- NetBeans (recomendado)
- Archivos `.dat` incluidos para pruebas (no editar manualmente)

### Instrucciones
1. Clonar el repositorio:
```bash
git clone https://github.com/diartavia/Proyecto-Final_Canvas_IngRS.git
