\# Evaluation



We evaluate PromptSyntax through a regression-based compiler validation study. The goal is to assess whether the language frontend, semantic analyzer, intermediate representation, and backend prompt generators correctly accept valid PromptSyntax programs and reject invalid programs.



\## Benchmark Suite



The benchmark contains 26 PromptSyntax programs: 10 valid programs and 16 invalid programs. The valid programs cover core entities, enumerations, generic types, entity relationships, methods, inheritance, interfaces, contracts, and modules. The invalid programs cover duplicate declarations, unknown types, invalid method types, invalid generic types, invalid inheritance, unknown interfaces, directive conflicts, and malformed contracts.



| Category | Passed | Total | Accuracy |

|---|---:|---:|---:|

| Valid programs accepted | 10 | 10 | 100% |

| Invalid programs rejected | 16 | 16 | 100% |

| Overall | 26 | 26 | 100% |



\## Feature Coverage



| Feature | Supported | Tested |

|---|:---:|:---:|

| Entity declarations | Yes | Yes |

| Fields | Yes | Yes |

| Enumerations | Yes | Yes |

| Generic types | Yes | Yes |

| Entity relationships | Yes | Yes |

| Methods | Yes | Yes |

| Method type checking | Yes | Yes |

| Inheritance | Yes | Yes |

| Interfaces | Yes | Yes |

| Contracts | Yes | Yes |

| Modules / namespaces | Yes | Yes |

| Backend prompt generation | Yes | Yes |



\## Backend Coverage



PromptSyntax lowers a shared PromptIR into backend-specific prompts for five LLM backends.



| Backend | Entities | Generics | Methods | Interfaces | Contracts | Modules |

|---|:---:|:---:|:---:|:---:|:---:|:---:|

| GPT | Yes | Yes | Yes | Yes | Yes | Yes |

| Claude | Yes | Yes | Yes | Yes | Yes | Yes |

| Gemini | Yes | Yes | Yes | Yes | Yes | Yes |

| Qwen | Yes | Yes | Yes | Yes | Yes | Yes |

| DeepSeek | Yes | Yes | Yes | Yes | Yes | Yes |



\## Invalid Program Categories



| Error Category | Tests |

|---|---:|

| Duplicate field | 1 |

| Duplicate method | 1 |

| Duplicate parameter | 1 |

| Duplicate interface field | 1 |

| Unknown field type | 1 |

| Unknown generic inner type | 1 |

| Unknown map value type | 1 |

| Unknown method parameter type | 1 |

| Unknown method return type | 1 |

| Unknown parent entity | 1 |

| Self inheritance | 1 |

| Unknown interface | 1 |

| Builder without constructor | 1 |

| run\_tests without tests | 1 |

| Invalid contract syntax | 2 |

| Total | 16 |



\## Summary



The current implementation passes all 26 benchmark programs. This result shows that PromptSyntax provides a working compiler pipeline from source programs to backend-specific prompts, while enforcing static checks over types, inheritance, interfaces, methods, contracts, and generation directives.

