# Gemini ChatBot App

Gemini ChatBot es una aplicación de Android diseñada para ofrecer una experiencia interactiva mediante el uso de un modelo generativo basado en **Gemini Pro**. Esta aplicación aprovecha Jetpack Compose para la interfaz de usuario, lo que garantiza una experiencia visual moderna y fluida.

---


https://github.com/user-attachments/assets/26a5198a-93e0-495a-a58e-a824cebfaff7



## 🛠️ Características
- **Interfaz moderna:** Diseñada con Jetpack Compose y Material 3.
- **Modelo generativo:** Implementación de la API de **Gemini Pro** para responder preguntas y mantener una conversación dinámica.
- **Gestión de mensajes:** Historial interactivo y adaptable.
- **Animaciones sutiles:** Experiencia más fluida con transiciones visuales.
- **Validación de mensajes:** Control para evitar envíos vacíos.
- **Manejo de excepciones:** Gestión robusta de errores al interactuar con la API.

---

## 📋 Requisitos previos
- **Android Studio Flamingo o superior.**
- **Java 17** o superior configurado en el entorno de desarrollo.
- Conexión a Internet para interactuar con el modelo **Gemini Pro**.
- Clave API válida para acceder a **Gemini Pro**.

---

## 🚀 Configuración del Proyecto

### Clonar el Repositorio
```bash
git clone https://github.com/tu-usuario/gemini-chatbot.git
```

## Configurar la Clave API
En el archivo Constants.kt (ubicado en el paquete com.devjamiro.geminichatbot), agrega tu clave API:
```bash
object Constants {
    const val apiKey = "TU_CLAVE_API"
}
```
Asegúrate de mantener la clave en privado. Puedes usar un sistema de variables de entorno o un archivo de configuración externo si lo prefieres.

## 🏗️ Arquitectura

### Estructura
* MainActivity: Configuración principal y gestión del diseño.
* ChatPage y componentes: Implementación de la interfaz de usuario, incluyendo:
* MessageList
* MessageRow
* MessageInput
* ChatViewModel: Manejo de lógica de negocio y comunicación con el modelo generativo.
* MessageModel: Modelo de datos para representar los mensajes.
