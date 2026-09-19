# Evidencia de la semana · GitHub Copilot
Alumno: Lizbeth Joseline Inzunza Pereyra · Repo: https://github.com/lizinzunza934/taskflow-copilot-lizinzunza934

## Día 1 · La CLI
- **Qué construí:** Configuré la CLI de Copilot, establecí directivas de sistema globales y automaticé la documentación de la arquitectura inicial del proyecto usando un archivo de instrucciones de contexto.
- **Dónde está:** `.github/copilot-instructions.md`, `docs/ARQUITECTURA.md`
- **Cómo se comprueba:** `evidencia/dia1/verificador.txt`, última línea `0 NO EXISTE`
- **Qué no salió:** Nada, toda la configuración inicial y la generación de la documentación se ejecutaron sin errores estructurales.

## Día 2 · Especificar, implementar y revisar
- **Qué construí:** Desarrollé los endpoints `GET /tasks/overdue` y `GET /tasks/unassigned` delegando la implementación y las pruebas unitarias al LLM a partir de especificaciones estrictas en formato Markdown.
- **Dónde está:** `specs/overdue.md`, `specs/unassigned.md`, y el código en `src/main` y `src/test`.
- **Cómo se comprueba:** `evidencia/dia2/comprobacion.txt` (overdue → 7, unassigned → 4 y 6), `evidencia/dia2/pr.txt`, `evidencia/dia2/suite-main.txt` y `evidencia/dia2/usage.txt`.
- **Qué no salió:** Al inicio el modelo intentó modificar código existente en lugar de solo agregar lo nuevo. Lo solucioné usando `git restore` para revertir y ejecutando el prompt de nuevo restringiendo herramientas y rutas.

## Día 3 · MCP
- **Qué construí:** Empaqueté y encendí servidores locales y remotos bajo el Model Context Protocol (MCP) para dotar a Copilot de herramientas físicas como acceso a la API (taskflow), navegación web (playwright) y búsqueda en documentación (aws-knowledge).
- **Dónde está:** `taskflow-mcp/` (servidor en Java), `issues/summary.md`.
- **Cómo se comprueba:** `evidencia/dia3/mcp-list-inicio.txt`, `evidencia/dia3/issue-summary.txt`, `evidencia/dia3/aws-auditoria.txt`, `evidencia/dia3/playwright-tarea.txt`, y `evidencia/dia3/integrador.md`.
- **Qué no salió:** Nada, los tres servidores respondieron correctamente tras compilar el `.jar` de la aplicación de integración.

## Día 4 · Skills y agentes
- **Qué construí:** Diseñé agentes con permisos restringidos (solo lectura para el `revisor`) y encapsulé patrones de código y scripts E2E en "skills" reutilizables, logrando una auditoría de infraestructura segura en AWS.
- **Dónde está:** `.github/skills/crear-endpoint-taskflow/`, `.github/skills/verificar-taskflow/`, `.github/agents/revisor.agent.md`, `.github/agents/tester.agent.md`.
- **Cómo se comprueba:** `evidencia/dia4/verificar.txt` (termina en RESULTADO: 8/8 OK), `evidencia/dia4/aws-resultado.txt` (cuenta enmascarada), y los archivos `.md` de sesión del revisor y tester.
- **Qué no salió:** En la implementación del endpoint `/summary` mediante la skill, el agente alcanzó el tope de `--max-ai-credits`. Apliqué el plan de contingencia utilizando la versión de referencia para mantener el flujo sin terminar el presupuesto mensual.

## Día 5 · VS Code y proyecto final
- **Qué construí:** Trasladé el ecosistema de MCP, agentes y skills al entorno gráfico de VS Code. Desarrollé el proyecto final (`GET /tasks/search?q=api`), el cual superó auditorías autónomas, Code Review de GitHub y pruebas reales HTTP.
- **Dónde está:** `.vscode/mcp.json`, `specs/search.md`, y el reporte final en `semana6/README.md`.
- **Cómo se comprueba:** El script `verificar.ps1` en la rama main (RESULTADO: 14/14 OK) y el Pull Request fusionado detallado en la sección 5 del documento `semana6/README.md`.
- **Qué no salió:** Al probar comandos integrados de lectura en el chat, el agente de VS Code no leía inicialmente los archivos. Se corrigió cambiando el modelo de 'Auto' a 'GPT-5 mini' y forzando la indexación local con la etiqueta `@workspace`.

## Cierre
- **Créditos:** En el mes gasté un aproximado de 154 créditos (según github.com/settings/billing). Para gastar menos en el futuro, establecería políticas restrictivas con `--deny-tool` por defecto, aprovecharía el texto fantasma de VS Code (que no cuesta créditos) para tareas mecánicas, y mantendría banderas protectoras como `--max-ai-credits` en un rango conservador (ej. 15-20) para cortar bucles de error a tiempo.
- **Una cosa que el agente hizo mal:** Durante el Proyecto Final, el agente omitió escribir un caso de prueba negativo en `BusquedaTareasServiceTest.java` (faltaba la aserción `verify(..., never())`) y dejó un import huérfano. Lo detectó el agente `revisor` (en modo lectura), y quedó corregido al inyectarle eso al modelo con un nuevo prompt que autorizaba reescribir exclusivamente los archivos de test.